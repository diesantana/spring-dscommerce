# Projeto DSCommerce (Backend)

Este projeto de backend foi desenvolvido durante o curso Java Spring Professional ministrado pelo professor e Dr Nelio Alves na instituição Devsuperior.  
A aplicação utiliza Spring JPA e o banco de dados H2 para testes, com o objetivo de criar um sistema de E-commerce simplificado para gerenciar produtos, categorias e usuários.

## Funcionalidades

- Cadastro de Usuários: Permite registrar informações como nome, email e senha.
- Cadastro de Produtos: Permite adicionar produtos com nome, descrição, preço e categoria.
- Cadastro de Categorias: Permite criar categorias para os produtos.
- Listagem de Produtos: Exibe a lista de produtos cadastrados.
- Filtragem de Produtos por Categoria: Permite filtrar os produtos por categoria.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- Banco de Dados H2 (em memória)


## Modelagem do Banco de Dados

- A tabela User armazena os dados dos usuários.
- A tabela Product contém as informações dos produtos.
- A tabela Category armazena as categorias dos produtos.
- Relacionamentos:
  - Um usuário pode ter vários produtos.
  - Um produto pertence a uma única categoria.
  


## Autor

- Diego Alves Santana