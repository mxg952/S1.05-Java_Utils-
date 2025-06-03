package main.level1.ex5.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer {

    private static final String FILE_PATH = "src/main/level1/resources/country.ser";

    public static void serializeObject(Serializable object) {

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(FILE_PATH);
            System.out.println("Object serialized to: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error serializing the object: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Country country = new Country("Senegal", 10000000);
            serializeObject(country);
    }

}
