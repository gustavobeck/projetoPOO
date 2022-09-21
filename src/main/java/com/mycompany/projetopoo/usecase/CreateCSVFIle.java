package com.mycompany.projetopoo.usecase;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateCSVFIle {

    private CreateCSVFIle() {
    }

    public static void createCSVFile(final Map<String, List<String>> text, final String titulo) {

        final List<String[]> linhas = new ArrayList<>();
        text.forEach((key, value) -> linhas.add(new String[]{key, value.toString().replaceAll("[\\[\\]]", "")}));

        try {
            final Writer writer = Files.newBufferedWriter(Paths.get("src/main/java/com/mycompany/projetopoo/csvfiles/" + titulo + ".csv"));
            try (final CSVWriter csvWriter = new CSVWriter(writer)) {

                csvWriter.writeAll(linhas);

                csvWriter.flush();
            }
            writer.close();
        } catch (final IOException i) {
            i.printStackTrace();
        }
    }
}
