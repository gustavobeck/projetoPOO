package com.mycompany.projetopoo.usecase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class responsible for read a text
 */
public class ReadText {

    private ReadText() {
    }

    /**
     * Method responsible for reading a file inside the "textfiles" folder in the project
     *
     * @param fileName this string contains a file name of a text that will be read
     * @return a string with the contents of the file or an empty string in case it can't find or read the file
     */
    public static String readText(final String fileName) {

        try {
            final Path filePath = Paths.get("src/main/java/com/mycompany/projetopoo/textfiles/" + fileName + ".txt");

            return Files.readString(filePath);
        } catch (final IOException e) {
            System.err.println("File could not be found/read: " + fileName + ".txt");
        }
        return "";
    }
}
