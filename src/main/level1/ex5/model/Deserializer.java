package main.level1.ex5.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer {
    private static final String FILE_PATH = "src/main/level1/resources/country.ser";

    public static Country deserializeObject() {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                Object object = inputStream.readObject();
                if (object instanceof Country) {
                    System.out.println("Object successfully deserialized: " + FILE_PATH);
                    return (Country) object;
                } else {
                    System.err.println("The object in the file is not of type JavaObject.");
                    return null;
                }
            } catch (ClassNotFoundException | IOException e) {
                System.err.println("Error deserializing the object: " + e.getMessage());
                return null;
            }
        }

    public static void main(String[] args) {
        Country deserialized = deserializeObject();  // Crida sense arguments
        if (deserialized != null) {
            System.out.println("Deserialized object content: " + deserialized);
        }
    }
}

