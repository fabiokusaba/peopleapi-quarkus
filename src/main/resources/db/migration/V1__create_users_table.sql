-- Criação da tabela
CREATE TABLE tb_users (
    id UUID NOT NULL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Inserção de usuários iniciais
INSERT INTO tb_users (id, username, email) VALUES
('11111111-1111-1111-1111-111111111111', 'alice', 'alice@example.com'),
('22222222-2222-2222-2222-222222222222', 'bob', 'bob@example.com'),
('33333333-3333-3333-3333-333333333333', 'carol', 'carol@example.com'),
('44444444-4444-4444-4444-444444444444', 'dave', 'dave@example.com'),
('55555555-5555-5555-5555-555555555555', 'eve', 'eve@example.com');
