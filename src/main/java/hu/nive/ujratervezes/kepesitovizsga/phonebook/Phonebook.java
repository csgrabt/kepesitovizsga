package hu.nive.ujratervezes.kepesitovizsga.phonebook;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Phonebook {

    public static final String KEY_VALUE_SEPARATOR = ": ";

    public void exportPhonebook(Map<String, String> contacts, String outputPath) {
        validator(contacts, outputPath);

        Path pathOfFile = Path.of(outputPath);

        try (BufferedWriter br = Files.newBufferedWriter(pathOfFile, StandardCharsets.UTF_8)) {
            writingFile(contacts, br);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Something went wrong while writing the file!", ioe);
        }
    }

    private void writingFile(Map<String, String> contacts, BufferedWriter br) throws IOException {
        List<String> keys = new ArrayList<>(contacts.keySet());
        for (String item : keys
        ) {
            br.write(item + KEY_VALUE_SEPARATOR + contacts.get(item) + "\n");
        }
    }

    private void validator(Map<String, String> contacts, String outputPath) {
        if (contacts == null || outputPath == null) {
            throw new IllegalArgumentException("Contacts or/and outputPath is/are null!");
        }
    }
}
