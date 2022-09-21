package com.mycompany.projetopoo.usecase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadText {

    private ReadText() {
    }

    public static String readText(final String title) {

        try {
            final Path fileName = Paths.get("src/main/java/com/mycompany/projetopoo/textfiles/" + title + ".txt");

            return Files.readString(fileName);
        } catch (final IOException e) {
            System.err.println("File could not be read: " + title + ".txt");
        }
        return "";
    }
}
