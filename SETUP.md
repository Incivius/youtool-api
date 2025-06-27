# 🚀 Setup Guide - YouTool API

Este guia explica como configurar o ambiente para executar a YouTool API em diferentes sistemas operacionais.

## 📋 Pré-requisitos

- **Java 21+** (OpenJDK ou Oracle JDK)
- **Python 3.8+**
- **MongoDB** (executando na porta 28017)
- **Maven** (incluído via wrapper no projeto)

## 🐧 Linux / 🍎 macOS

### 1. Clonar o repositório
```bash
git clone <repository-url>
cd youtool-api
```

### 2. Configurar ambiente Python
```bash
# Criar ambiente virtual
python3 -m venv venv

# Ativar ambiente virtual
source venv/bin/activate

# Instalar dependências
pip install youtool
```

### 3. Configurar e executar aplicação Java
```bash
# Dar permissão de execução ao Maven wrapper
chmod +x mvnw

# Compilar o projeto
./mvnw clean compile

# Executar a aplicação
./mvnw spring-boot:run
```

## 🪟 Windows

### 1. Clonar o repositório
```cmd
git clone <repository-url>
cd youtool-api
```

### 2. Configurar ambiente Python
```cmd
# Criar ambiente virtual
python -m venv venv

# Ativar ambiente virtual
venv\Scripts\activate

# Instalar dependências
pip install youtool
```

### 3. Configurar e executar aplicação Java
```cmd
# Compilar o projeto
mvnw.cmd clean compile

# Executar a aplicação
mvnw.cmd spring-boot:run
```

## 🔧 Estrutura do Projeto

```
youtool-api/
├── scripts/                    # Scripts Python
│   ├── get_channel_data.py    # Obter dados do canal
│   ├── get_video_comments.py  # Obter comentários
│   ├── get_transcription.py   # Obter transcrições
│   └── transcriptions/        # Arquivos de transcrição
├── venv/                      # Ambiente virtual Python
├── src/                       # Código fonte Java
└── pom.xml                    # Configuração Maven
```

## 🌐 Endpoints da API

- `GET /youtube/channel?url={url}` - Obter dados do canal
- `GET /youtube/video-comments?videoId={id}` - Obter comentários do vídeo
- `GET /youtube/video/transcription?videoId={id}` - Obter transcrição do vídeo

## 🔍 Testando

Após iniciar a aplicação, teste um endpoint:

```bash
curl "http://localhost:8080/youtube/video-comments?videoId=6aXyWMH6KLE"
```

## 🐛 Solução de Problemas

### Erro "Python interpreter not found"
- Verifique se o ambiente virtual foi criado corretamente
- No Windows: certifique-se que `venv\Scripts\python.exe` existe
- No Linux/Mac: certifique-se que `venv/bin/python` existe

### Erro "Script not found"
- Verifique se os scripts estão na pasta `scripts/`
- Certifique-se que os arquivos têm as extensões `.py`

### Erro de conexão com MongoDB
- Verifique se o MongoDB está executando na porta 28017
- Ajuste a configuração em `application.properties` se necessário

## 🔧 Características Multiplataforma

O `PythonScriptRunner.java` foi desenvolvido para detectar automaticamente o sistema operacional e usar os caminhos corretos:

- **Windows**: `venv\Scripts\python.exe`
- **Linux/Mac**: `venv/bin/python`

Não são necessárias modificações no código para executar em diferentes SOs!
