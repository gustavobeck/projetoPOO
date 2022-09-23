package com.mycompany.projetopoo.usecase;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class responsible for create a csv file
 */
public class CreateCSVFIle {

    private CreateCSVFIle() {
    }

    /**
     * Method responsible for write a csv file with an adjacency list map
     *
     * @param map   this map contains a map with key = adjacency list and value = destination words list
     * @param title this string contains the filename of the text read
     */
    public static void createCSVFile(final Map<String, List<String>> map, final String title) {

        final List<String[]> linhas = new ArrayList<>();
        map.forEach((key, value) -> linhas.add(new String[]{key, value.toString().replaceAll("[\\[\\]]", "")}));

        try {
            final Writer writer = Files.newBufferedWriter(Paths.get("src/main/java/com/mycompany/projetopoo/csvfiles/" + title + ".csv"));
            try (final CSVWriter csvWriter = new CSVWriter(writer)) {

                csvWriter.writeAll(linhas);

                csvWriter.flush();
            }
            writer.close();
        } catch (final IOException i) {
            System.err.println("Error writing the csv file for the file: " + title + ".txt");
        }
    }
}
