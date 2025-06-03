package main.level1.ex2.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DirectoryTree {

        public static void listDirectoryRecursively(File dir) {
            if (!dir.exists() || !dir.isDirectory()) {
                System.out.println("Invalid directory: " + dir.getPath());
                return;
            }

            File[] files = dir.listFiles();
            if (files == null) return;

            Arrays.sort(files, Comparator.comparing(File::getName));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (File file : files) {
                String type = file.isDirectory() ? "[D]" : "[F]";
                String lastModify = sdf.format(new Date(file.lastModified()));
                System.out.println(type + " " + file.getAbsolutePath() + " - " + lastModify);

                if (file.isDirectory()) {
                    listDirectoryRecursively(file);
                }
            }
        }

        public static void main(String[] args) {
            if (args.length != 1) {
                System.out.println("Please provide a directory path.");
                return;
            }

            File directory = new File(args[0]);
            listDirectoryRecursively(directory);
        }
    }

