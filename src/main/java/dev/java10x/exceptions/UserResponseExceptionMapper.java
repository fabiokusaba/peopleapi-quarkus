package dev.java10x.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class UserResponseExceptionMapper implements ExceptionMapper<UserNotFoundException> {

    @Override
    public Response toResponse(UserNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(Map.of("status", 404, "message", "User not found!"))
                .build();
    }
}
