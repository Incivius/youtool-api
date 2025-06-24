package com.youtool_api.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PythonScriptRunner {

    public static String runYouTubeScript(String channelUrl) {
        try {
            // para windows
            String pythonInterpreter = "C:\\Users\\Home\\Desktop\\Repositorios\\Massaori\\youtool-api\\src\\main\\java\\com\\youtool_api\\scripts\\python\\venv\\Scripts\\python.exe";
            String scriptPath = "C:\\Users\\Home\\Desktop\\Repositorios\\Massaori\\youtool-api\\src\\main\\java\\com\\youtool_api\\scripts\\python\\get_channel_data.py";
            // para o meu linux
            // String pythonInterpreter = "/home/jhonatan/Github/youtool-api/src/main/java/com/youtool_api/scripts/python/venv/bin/python";
            // String scriptPath = "/home/jhonatan/Github/youtool-api/src/main/java/com/youtool_api/scripts/python/get_channel_data.py";

            ProcessBuilder pb = new ProcessBuilder(
                    pythonInterpreter,
                    scriptPath,
                    channelUrl);

            // IMPORTANTE: não redirecione os erros junto com stdout para conseguir ver
            // separadamente
            // pb.redirectErrorStream(true); // <- REMOVIDO

            Process process = pb.start();

            // Lê stdout
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[PYTHON STDOUT] " + line); // <- PRINTA O QUE SAI DO PYTHON
                    output.append(line);
                }
            }

            // Lê stderr (erros)
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream(), StandardCharsets.UTF_8))) {
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    System.err.println("[PYTHON STDERR] " + errorLine); // <- PRINTA ERROS
                }
            }

            int exitCode = process.waitFor();
            System.out.println("[JAVA DEBUG] Código de saída: " + exitCode);

            if (exitCode == 0) {
                return output.toString(); // JSON vindo do Python
            } else {
                return "{\"error\": \"Script Python terminou com código diferente de 0.\"}";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Exceção ao executar script: " + e.getMessage() + "\"}";
        }
    }

    public static String runGetVideoCommentsScript(String videoId) {
        try {
            String pythonInterpreter = "C:\\Users\\Home\\Desktop\\Repositorios\\Massaori\\youtool-api\\src\\main\\java\\com\\youtool_api\\scripts\\python\\venv\\Scripts\\python.exe";
            String scriptPath = "C:\\Users\\Home\\Desktop\\Repositorios\\Massaori\\youtool-api\\src\\main\\java\\com\\youtool_api\\scripts\\python\\get_video_comments.py";

            ProcessBuilder pb = new ProcessBuilder(
                    pythonInterpreter,
                    scriptPath,
                    videoId);

            Process process = pb.start();

            // Lê stdout
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[PYTHON STDOUT] " + line);
                    output.append(line);
                }
            }

            // Lê stderr
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream(), StandardCharsets.UTF_8))) {
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    System.err.println("[PYTHON STDERR] " + errorLine);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("[JAVA DEBUG] Código de saída: " + exitCode);

            if (exitCode == 0) {
                return output.toString(); // JSON do script Python
            } else {
                return "{\"error\": \"Script Python terminou com código diferente de 0.\"}";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Exceção ao executar script: " + e.getMessage() + "\"}";
        }
    }

    public static String runGetTranscriptionScript(String videoId) {
        try {
            String pythonInterpreter = "C:\\Users\\Home\\Desktop\\Repositorios\\Massaori\\youtool-api\\src\\main\\java\\com\\youtool_api\\scripts\\python\\venv\\Scripts\\python.exe";
            String scriptPath = "C:\\Users\\Home\\Desktop\\Repositorios\\Massaori\\youtool-api\\src\\main\\java\\com\\youtool_api\\scripts\\python\\get_transcription.py";

            ProcessBuilder pb = new ProcessBuilder(
                    pythonInterpreter,
                    scriptPath,
                    videoId);

            Process process = pb.start();

            // Lê stdout
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[PYTHON STDOUT] " + line);
                    output.append(line);
                }
            }

            // Lê stderr
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream(), StandardCharsets.UTF_8))) {
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    System.err.println("[PYTHON STDERR] " + errorLine);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("[JAVA DEBUG] Código de saída: " + exitCode);

            if (exitCode == 0) {
                return output.toString(); // JSON do script Python
            } else {
                return "{\"error\": \"Script Python terminou com código diferente de 0.\"}";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Exceção ao executar script: " + e.getMessage() + "\"}";
        }
    }

}
