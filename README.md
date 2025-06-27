# 🎥 YouTool API

API RESTful para coletar dados do YouTube usando a biblioteca Youtool e armazenar no MongoDB.

## 🚀 Quick Start

### Usando Docker (Recomendado)
```bash
docker-compose up
```

### Setup Manual
Veja o [guia completo de instalação](./SETUP.md) para instruções detalhadas para Windows, Linux e macOS.

## 📋 Requisitos

- **Java 21+** (OpenJDK ou Oracle JDK)
- **Python 3.8+**
- **MongoDB**
- **Docker** (opcional, para container)

## 🌐 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/youtube/channel?url={url}` | Obter dados do canal YouTube |
| `GET` | `/youtube/video-comments?videoId={id}` | Obter comentários do vídeo |
| `GET` | `/youtube/video/transcription?videoId={id}` | Obter transcrição do vídeo |

## 📁 Estrutura do Projeto

```
youtool-api/
├── 🐍 scripts/              # Scripts Python (Youtool)
├── ☕ src/                  # Código fonte Java (Spring Boot)
├── 🐍 venv/                 # Ambiente virtual Python  
├── 🐳 docker-compose.yml    # Configuração Docker
└── 📋 requirements.txt      # Dependências Python
```

## 🔧 Características

- ✅ **Multiplataforma**: Funciona em Windows, Linux e macOS
- ✅ **Docker Ready**: Container pronto para produção
- ✅ **API RESTful**: Endpoints padronizados e documentados
- ✅ **MongoDB**: Persistência NoSQL para dados do YouTube
- ✅ **Error Handling**: Tratamento robusto de erros
- ✅ **Logs Detalhados**: Debug facilitado com logs informativos

### 🔧 Maven

* Necessário: **Maven 3.9.0+**

---

## 🔍 Verifique no terminal

```bash
java -version
mvn -version
```

---

## 📦 Downloads

* [JDK 21](https://jdk.java.net/21/)
* [Maven](https://maven.apache.org/download.cgi)

---

## 📌 Resumo

| Ferramenta | Versão mínima |
| ---------- | ------------- |
| Java       | 21            |
| Maven      | 3.9.0         |

---

## Instalar dependências do maven

```
mvn clean install -DskipTests
```

## Rodar o projeto

```
mvn spring-boot: run
```