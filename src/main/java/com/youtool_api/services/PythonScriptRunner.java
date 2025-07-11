package com.youtool_api.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class PythonScriptRunner {

    private static final String SCRIPTS_FOLDER = "scripts";
    

    private static String getPythonInterpreter() {
        String workspaceRoot = getWorkspaceRoot();
        String os = System.getProperty("os.name").toLowerCase();
        
        if (os.contains("win")) {
            return Paths.get(workspaceRoot, "venv", "Scripts", "python.exe").toString();
        } else {
            return Paths.get(workspaceRoot, "venv", "bin", "python").toString();
        }
    }
    

    private static String getScriptPath(String scriptName) {
        String workspaceRoot = getWorkspaceRoot();
        return Paths.get(workspaceRoot, SCRIPTS_FOLDER, scriptName).toString();
    }
    

    private static String getWorkspaceRoot() {
        return System.getProperty("user.dir");
    }
    

    private static boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    public static String runYouTubeScript(String channelUrl) {
        try {
            String pythonInterpreter = getPythonInterpreter();
            String scriptPath = getScriptPath("get_channel_data.py");

            if (!fileExists(pythonInterpreter)) {
                return "{\"error\": \"Python interpreter not found at: " + pythonInterpreter + "\"}";
            }
            if (!fileExists(scriptPath)) {
                return "{\"error\": \"Script not found at: " + scriptPath + "\"}";
            }

            ProcessBuilder pb = new ProcessBuilder(
                    pythonInterpreter,
                    scriptPath,
                    channelUrl);

            Process process = pb.start();

            // Lê stdout
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[PYTHON STDOUT] " + line); // <- PRINTA O QUE SAI DO PYTHON
                    output.append(line).append("\n");
                }
            }

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
                String result = output.toString().trim();
                System.out.println("[JAVA DEBUG] JSON recebido: " + result);
                return result;
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
            String pythonInterpreter = getPythonInterpreter();
            String scriptPath = getScriptPath("get_video_comments.py");

            // Verificar se os arquivos existem
            if (!fileExists(pythonInterpreter)) {
                return "{\"error\": \"Python interpreter not found at: " + pythonInterpreter + "\"}";
            }
            if (!fileExists(scriptPath)) {
                return "{\"error\": \"Script not found at: " + scriptPath + "\"}";
            }

            ProcessBuilder pb = new ProcessBuilder(
                    pythonInterpreter,
                    scriptPath,
                    videoId);

            Process process = pb.start();


            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[PYTHON STDOUT] " + line);
                    output.append(line).append("\n");
                }
            }


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
                String result = output.toString().trim();
                System.out.println("[JAVA DEBUG] JSON recebido: " + result);
                return result; // JSON do script Python
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
            String pythonInterpreter = getPythonInterpreter();
            String scriptPath = getScriptPath("get_transcription.py");


            if (!fileExists(pythonInterpreter)) {
                return "{\"error\": \"Python interpreter not found at: " + pythonInterpreter + "\"}";
            }
            if (!fileExists(scriptPath)) {
                return "{\"error\": \"Script not found at: " + scriptPath + "\"}";
            }

            ProcessBuilder pb = new ProcessBuilder(
                    pythonInterpreter,
                    scriptPath,
                    videoId);

            Process process = pb.start();


            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[PYTHON STDOUT] " + line);
                    output.append(line).append("\n");
                }
            }


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
                String result = output.toString().trim();
                System.out.println("[JAVA DEBUG] JSON recebido: " + result);
                return result;
            } else {
                return "{\"error\": \"Script Python terminou com código diferente de 0.\"}";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Exceção ao executar script: " + e.getMessage() + "\"}";
        }
    }

}
