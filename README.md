# youtool-api
API para coletar dados do YouTube com Youtool.dev e armazenar no MongoDB


## Rode o container com o comando

```
docker-compose up
```

certifique-se de estar na pasta ../youtool-api e ter o docker instalado

# Java

## ✅ Requisitos para rodar o projeto

### 🔧 Java

* Necessário: **JDK 21**

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