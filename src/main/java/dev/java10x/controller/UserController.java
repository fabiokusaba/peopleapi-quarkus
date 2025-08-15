package dev.java10x.controller;

import dev.java10x.domain.Users;
import dev.java10x.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAllUsers(@QueryParam("page") @DefaultValue("0") Integer page,
                                 @QueryParam("size") @DefaultValue("10") Integer size) {
        var users = userService.findAllUsers(page, size);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response findUserById(@PathParam("id")UUID userId) {
        return Response.ok(userService.findUserById(userId)).build();
    }

    @POST
    @Transactional
    public Response createUser(Users user) {
        return Response.ok(userService.createUser(user)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") UUID userId, Users user) {
        return Response.ok(userService.updateUser(userId, user)).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") UUID userId) {
        userService.deleteUser(userId);
        return Response.noContent().build();
    }
}
