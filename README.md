# 🎥 YouTool API

API RESTful desenvolvida em Java (Spring Boot) para coletar dados do YouTube usando a biblioteca [Youtool](https://pypi.org/project/youtool/) e armazená-los em um banco de dados MongoDB. A aplicação integra scripts Python para obter dados de canais, comentários e transcrições de vídeos.

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia      | Descrição                                                                 |
|------------------|---------------------------------------------------------------------------|
| **Java 21**      | Linguagem principal da API (com Spring Boot)                             |
| **Spring Boot**  | Framework para criação de APIs RESTful em Java                           |
| **Python 3.8+**  | Utilizado para scripts que coletam dados do YouTube                      |
| **YouTool**      | Biblioteca Python para extração de dados de vídeos, canais e comentários |
| **MongoDB**      | Banco de dados NoSQL para armazenar os dados coletados                   |
| **Docker**       | Containerização do banco MongoDB                                         |
| **Maven 3.9+**   | Gerenciador de dependências e build da aplicação Java                    |
| **MongoDB Compass** | Ferramenta visual para inspeção dos dados armazenados               |


## 📋 Requisitos

Ferramenta

- Java   
- Python    
- Maven     
- MongoDB   
- Docker   

---

## 🧪 Instalação e Execução

### 1. Instalar dependências do Maven

```bash
mvn clean install -DskipTests
```

### 2. Subir MongoDB com Docker

```bash
docker-compose up -d
```

## 🛠️ Setup Manual

### 🐧 Linux / 🍎 macOS

```bash
# Criar ambiente Python
python3 -m venv venv

# Ativar ambiente virtual
source venv/bin/activate

# Instalar dependências
pip install youtool
pip install yt_dlp

# Permissão para Maven wrapper
chmod +x mvnw

# Compilar e rodar
./mvnw clean compile
./mvnw spring-boot:run
```

---

### 🪟 Windows

```cmd
# Criar ambiente Python
python3 -m venv venv

# Ativar ambiente virtual
source venv/bin/activate

# Instalar dependências
pip install youtool
pip install yt_dlp

# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn spring-boot:run
```

---

## 🌐 Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/youtube/channel?url={url}` | Obter dados do canal YouTube e salvar no banco |
| `GET` | `/youtube/video-comments?videoId={id}` | Obter e salvar comentários de um vídeo |
| `GET` | `/youtube/video/transcription?videoId={id}` | Obter transcrição de um vídeo |

### Exemplos com `curl`

```bash
curl "http://localhost:8080/youtube/channel?url=https://www.youtube.com/c/CursoemV%C3%ADdeo"

curl "http://localhost:8080/youtube/video-comments?videoId=dQw4w9WgXcQ"

curl "http://localhost:8080/youtube/video/transcription?videoId=dQw4w9WgXcQ"
```

---

## 🖼️ Demonstração

![Youtool ‐ Feito com o Clipchamp](https://github.com/user-attachments/assets/589a4bee-23c6-4977-99cb-c62e7d609873)

> Foi adicionado um vídeo no projeto com melhor qualidade 

---

## 📁 Estrutura do Projeto

```
youtool-api/
├── 🐍 scripts/              # Scripts Python (Youtool)
├── ☕ src/                  # Código fonte Java (Spring Boot)
├── 🐍 venv/                 # Ambiente virtual Python  
├── 🐳 docker-compose.yml    # Configuração Docker
└── 📋 requirements.txt      # Dependências Python
```

---

## 👥 Autores

<table style="width:100%; border-collapse: collapse;">
    <tr style="background-color: #620874; color: #06EF47;">
        <th style="text-align: center; text-align: center; padding: 10px;">Nome</th>
        <th style="text-align: center; text-align: center; padding: 10px;">LinkedIn & GitHub</th>
    </tr>
   <tr>
        <td style="text-align: center; text-align: center; padding: 10px;">Marcos Vinícius Malaquias</td>
        <td style="text-align: center; text-align: center; padding: 10px;">
            <a href="https://www.linkedin.com/in/marcos-malaquias/"><img src="https://img.shields.io/badge/-Linkedin-blue?style=flat-square&logo=Linkedin&logoColor=white" alt="LinkedIn"></a>
            <a href="https://github.com/Incivius"><img src="https://img.shields.io/badge/-GitHub-111217?style=flat-square&logo=github&logoColor=white" alt="GitHub"></a>
        </td>
    </tr>
    <tr>
        <td style="text-align: center; text-align: center; padding: 10px;">Jhonatan Lopes</td>
        <td style="text-align: center; text-align: center; padding: 10px;">
            <a href="https://www.linkedin.com/in/jhonatan-o-lopes/"><img src="https://img.shields.io/badge/-Linkedin-blue?style=flat-square&logo=Linkedin&logoColor=white" alt="LinkedIn"></a>
            <a href="https://github.com/JhonatanLop"><img src="https://img.shields.io/badge/-GitHub-111217?style=flat-square&logo=github&logoColor=white" alt="GitHub"></a>
        </td>
    </tr>
    <tr>
        <td style="text-align: center; padding: 10px;">Nicole Souza</td>
        <td style="text-align: center; padding: 10px;">
            <a href="https://www.linkedin.com/in/nicolem-souza/"><img src="https://img.shields.io/badge/-Linkedin-blue?style=flat-square&logo=Linkedin&logoColor=white" alt="LinkedIn"></a>
            <a href="https://github.com/NicSouza"><img src="https://img.shields.io/badge/-GitHub-111217?style=flat-square&logo=github&logoColor=white" alt="GitHub"></a>
        </td>
    </tr>
</table>
