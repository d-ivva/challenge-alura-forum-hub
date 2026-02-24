<div align="center">
  
  
  # 💬 Fórum Hub - API REST

![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-warning?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
</div>

## 📌 Sobre o Projeto
O Fórum Hub é uma API RESTful desenvolvida como parte do challenge da Alura. O objetivo do projeto é replicar o funcionamento de um fórum de dúvidas (como o próprio fórum da Alura), permitindo a criação, listagem, atualização e exclusão de tópicos.

Toda a API foi blindada utilizando **Spring Security** e a autenticação ocorre de forma *Stateless* através de **Tokens JWT**.

## 🚀 Funcionalidades (CRUD Completo)
- **`POST` /login**: Autenticação de usuários cadastrados e devolução do Token JWT.
- **`POST` /topicos**: Criação de um novo tópico.
- **`GET` /topicos**: Listagem de todos os tópicos.
- **`GET` /topicos/{id}**: Detalhamento de um tópico específico.
- **`PUT` /topicos/{id}**: Atualização dos dados de um tópico.
- **`DELETE` /topicos/{id}**: Exclusão/Inativação de um tópico.

  
  *Com exceção do login, todas as demais funcionalidades requerem autenticação.

## 🛠️ Tecnologias Utilizadas
* **Java 17+**
* **Spring Boot 3**
* **Spring Data JPA / Hibernate**
* **Spring Security**
* **Auth0 java-jwt** (Criação e Validação de Tokens)
* **MySQL** (Banco de Dados)
* **Insomnia** (Testes de API)

## 🚧 Próximos Passos
- [ ] Implementar classe para tratamento de erros global.
- [ ] Adicionar documentação visual da API com Spring Doc (Swagger).
- [ ] Expandir as demais entidades do Banco de Dados.
