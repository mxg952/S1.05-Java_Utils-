package main.level1.ex3.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirectoryTreeWriter {

    private static final String FILE_NAME = "src/main/level1/resources/directoryPaths.txt";

    public static void savePath(String dir, int level) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Directory: " + dir + " | Level: " + level);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving to directoryPaths.txt: " + e.getMessage());
        }

    }
    public void readFilePath() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String textline;
            System.out.println("Content of directoryPath.txt:");
            while ((textline = reader.readLine()) != null) {
                System.out.println(textline);
            }
        } catch (IOException e) {
            System.err.println("Error reading Path.txt: " + e.getMessage());
        }
    }

    public static void listDirectoryRecursively(String dir, int level) {
        File directory = new File(dir);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + directory.getPath());
            return;
        }

        File[] contents = directory.listFiles();

        if (contents != null) {
            for (File file : contents) {
                savePath(file.getAbsolutePath(), level);
                for (int i = 0; i < level; i++) {
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
        if (args.length != 1) {
            System.out.println("Please provide a directory path as an argument.");
            return;
        }

        DirectoryTreeWriter writer = new DirectoryTreeWriter();
        String directory = String.valueOf(new File(args[0]));

        new File(FILE_NAME).delete();

        listDirectoryRecursively(directory,0);

        writer.readFilePath();
    }


 }

