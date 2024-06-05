package br.edu.up.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {
    public static Map<String, String> loadEnvFile(String fileName) {
        Map<String, String> envMap = new HashMap<>();
        
        String filePath = Paths.get("").toAbsolutePath().toString() + "/" + fileName;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] keyValue = line.split("=", 2);
                if (keyValue.length == 2) {
                    envMap.put(keyValue[0], keyValue[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo .env: " + e.getMessage());
        }
        return envMap;
    }

    public static void main(String[] args) {
        Map<String, String> env = loadEnvFile(".env");
        env.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}
