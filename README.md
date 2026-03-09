# Empreendimentos API — SCTEC Desafio técnico para a trilha de IA para DEVs


API REST CRUD completa para gerenciamento de empreendimentos catarinenses, conforme desafio prático do Edital SCTEC "IA para DEVs".
Implementa todos os campos obrigatórios + UUID + validações + Docker zero-dependência.
---
##  Autor

**Felipe Feyh**
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Felipe%20Feyh-blue?logo=linkedin)](https://www.linkedin.com/in/felipe-feyh/)

---
## 🎥 Vídeo Pitch

[▶️ Assistir apresentação do projeto](https://youtu.be/C3FBXxorfB0)
---

## Tecnologias

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-build-red?logo=apachemaven)
![Docker](https://img.shields.io/badge/Docker-compose-blue?logo=docker)

| Tecnologia     | Versão / Detalhe     |
|----------------|----------------------|
| Java           | 21                   |
| Spring Boot    | 4.0.3 Maven          |
| JPA Hibernate  | —                    |
| H2 In-Memory   | —                    |
| Lombok         | —                    |
| Docker Compose | —                    |

---

##  Estrutura de Camadas
```
com.felipefeyh.empreendimentos/
├── entity/
│   └── Empreendimento.java        # UUID + validações @Valid
├── repository/
│   └── EmpreendimentoRepository   # JpaRepository
├── service/
│   └── EmpreendimentoService      # Business logic
├── controller/
│   └── EmpreendimentoController   # REST endpoints
└── exception/
    └── GlobalExceptionHandler     # 404 / 400
```

---

##  Execução

### 1. Maven Local (IntelliJ / VSCode)
```bash
./mvnw spring-boot:run
```

### 2. Docker
```bash
docker-compose up --build
```

### URLs

| Recurso      | URL                                        |
|--------------|--------------------------------------------|
| API          | http://localhost:8080/api/empreendimentos  |
| H2 Console   | http://localhost:8080/h2-console           |

> **H2 Console:** JDBC URL: `jdbc:h2:mem:testdb` · Usuário: `sa` · Senha: *(vazio)*

---

##  Endpoints

| Método   | Endpoint                          | Descrição               |
|----------|-----------------------------------|-------------------------|
| `POST`   | `/api/empreendimentos`            | Criar novo empreendimento |
| `GET`    | `/api/empreendimentos`            | Listar todos            |
| `GET`    | `/api/empreendimentos/{uuid}`     | Buscar por ID           |
| `PUT`    | `/api/empreendimentos/{uuid}`     | Atualizar               |
| `DELETE` | `/api/empreendimentos/{uuid}`     | Remover                 |

---

##  Validações & Exceções

- **Validações:** `@NotNull` / `@Size` / `@Email` → retorna `400` com JSON de erros por campo
- **Exceções:** `404` para ID não encontrado · `500` para erros genéricos

---

##  Desenvolvimento

- **Branches:** 7 features granulares (`feat/controller`, `feat/service`, `feat/docker`…)
- **Commits:** 14+ commits