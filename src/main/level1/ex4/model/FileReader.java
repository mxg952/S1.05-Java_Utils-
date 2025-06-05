package main.level1.ex4.model;

import java.io.BufferedReader;
import java.io.File;

public class FileReader {

    public static void main(String[] args) {
        String filePath = args[0];
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("The file does not exist or is invalid: " + filePath);
        }

        readAndDisplayFile(filePath);
    }


    private static void readAndDisplayFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error reading the file: " + filePath, e);
        }
    }
}
