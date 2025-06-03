package main.level1.ex1.model;

import java.io.File;
import java.util.Arrays;


public class DirectoryList {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a directory path as an argument.");
            return;
        }

        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The specified path does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The specified path is not a directory.");
            return;
        }

        String[] filesList = directory.list();

        if (filesList == null || filesList.length == 0) {
            System.out.println("The directory is empty.");
            return;
        }

        Arrays.sort(filesList);

        System.out.println("Content of directory '" + directoryPath + "' sorted alphabetically:");
        for (String fileName : filesList) {
            System.out.println(fileName);
        }
    }
}

