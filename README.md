# LinkHub API 🚀

Um gerenciador de links **pessoal** construído com Java e Spring Boot.

Este projeto é o backend de uma aplicação de gerenciamento de links, permitindo que os usuários salvem, organizem e acessem seus links da web de forma eficiente, através de uma API RESTful robusta e bem arquitetada.

---

## 📜 Descrição do Projeto

O **LinkHub API** nasceu como um **projeto pessoal de estudo** para solidificar conceitos de desenvolvimento backend moderno. A aplicação permite o gerenciamento completo de **Categorias** e **Links**, onde cada link pertence a uma categoria, simulando um cenário real de organização de dados.

A principal funcionalidade atual inclui a **criação de um código curto único para cada link**, preparando o terreno para funcionalidades futuras como redirecionamento e análise de cliques.

O projeto foi construído com foco total em **boas práticas de arquitetura**, como:
- Estrutura em **3 camadas**
- Uso do padrão **DTO**
- Design de API **RESTful**

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17  
- **Framework:** Spring Boot 3.x  
- **Módulos Spring:**
  - Spring Web – Criação de APIs RESTful
  - Spring Data JPA – Persistência de dados simplificada  
- **Build Tool:** Maven  

---

## 🏛️ Arquitetura

A arquitetura segue o padrão em **3 camadas**, promovendo **separação de responsabilidades**, **manutenibilidade** e **testabilidade**:

- **Controller Layer**: Porta de entrada da API. Lida com requisições HTTP e delega para o service.
- **Service Layer**: Contém a lógica de negócio e orquestra as operações entre DTOs e entidades.
- **Repository Layer**: Realiza a comunicação com o banco de dados usando Spring Data JPA.

➡️ O padrão **DTO** é utilizado para garantir que o modelo de persistência não seja exposto diretamente, promovendo segurança e flexibilidade na API.

---

## ✨ Features Implementadas

- ✅ **CRUD de Categorias**
- ✅ **Criação e listagem de Links**
- ✅ **Relacionamento entre Links e Categorias** (`@ManyToOne` / `@OneToMany`)
- ✅ **Geração automática de:**
  - ID da entidade (`@GeneratedValue`)
  - Data de criação (`LocalDateTime.now()`)
  - Código curto (`UUID` truncado)
- ✅ **Arquitetura limpa em 3 camadas**
- ✅ **Uso de DTOs para entrada e saída**
- ✅ **Tratamento básico de erros (HTTP 200, 201, 404)**

---

## 🔀 Endpoints da API

### 📁 Categorias

- `POST /api/categorias`  
  Cria uma nova categoria.

- `GET /api/categorias`  
  Lista todas as categorias.

---

### 🔗 Links

- `POST /api/categorias/{categoriaId}/links`  
  Cria um novo link associado a uma categoria existente.

- `GET /api/categorias/{categoriaId}/links`  
  Lista todos os links pertencentes a uma categoria.






