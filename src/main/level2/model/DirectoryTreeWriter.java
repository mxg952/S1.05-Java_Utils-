package main.level2.model;

import java.util.Properties;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class DirectoryTreeWriter {

    private static final String INPUT_DIR = "input.directory";
    private static final String OUTPUT_FILE = "output.file";
    private String inputDirectory;
    private String outputFilePath;


    private String loadConfig(String configPath) throws IOException {
        Properties properties = new Properties();

        try(InputStream inputStream = new FileInputStream(configPath)) {
            properties.load(inputStream);

        }
        inputDirectory = properties.getProperty(INPUT_DIR);
        outputFilePath = properties.getProperty(OUTPUT_FILE);

        if(inputDirectory == null || inputDirectory.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Property doesn't found in " + configPath);
        }

        System.out.println("Load configuration:");
        System.out.println("  input.directory = " + inputDirectory);
        System.out.println("  output.file     = " + outputFilePath);
        return configPath;
    }

    public void savePath(String dir, int level) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            writer.write("Directory: " + dir + " | Level: " + level);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving to directoryPaths.txt: " + e.getMessage());
        }

    }
    public void readFilePath() {
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFilePath))) {
            String textline;
            System.out.println("Content of directoryPath.txt:");
            while ((textline = reader.readLine()) != null) {
                System.out.println(textline);
            }
        } catch (IOException e) {
            System.err.println("Error reading Path.txt: " + e.getMessage());
        }
    }

    public void listDirectoryRecursively(String dir, int level) {
        File directory = new File(dir);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directory.getPath());
            return;
        }

        File[] contents = directory.listFiles();

        if (contents != null) {
            for (File file : contents) {
                savePath(file.getAbsolutePath(), level);                for (int i = 0; i < level; i++) {
                    System.out.print("    ");
                }
                System.out.println("Directory/File: " + file.getAbsolutePath() + " | Level: " + level);

                if (file.isDirectory()) {
                    listDirectoryRecursively(file.getAbsolutePath(), level + 1);
                }
            }
        } else {
            System.err.println("Could not read the contents of the directory: " + dir);
        }
    }

    public static void main(String[] args) {
        DirectoryTreeWriter directoryTreeWriter = new DirectoryTreeWriter();

        try{
            directoryTreeWriter.loadConfig(directoryTreeWriter.loadConfig("/home/mxg/MegaSync/IT_Academy/2_Especialització/S1.05-Java_Utils/src/main/level2/model/resources/config.properties"));

            File outFile = new File(directoryTreeWriter.outputFilePath);
            if (outFile.exists()) {
                outFile.delete();
            }

            directoryTreeWriter.listDirectoryRecursively(directoryTreeWriter.inputDirectory, 0);

            directoryTreeWriter.readFilePath();

            System.out.println("Procés completat correctament.");
        } catch (IOException e) {
            System.err.println("Error en processar fitxers o configuració: " + e.getMessage());
            e.printStackTrace();

        }

    }

 }

