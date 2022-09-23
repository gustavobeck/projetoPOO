/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projetopoo.service;

import com.mycompany.projetopoo.usecase.CreateCSVFIle;
import com.mycompany.projetopoo.usecase.FormatText;
import com.mycompany.projetopoo.usecase.OrdenateList;
import com.mycompany.projetopoo.usecase.ReadText;
import org.apache.commons.lang3.StringUtils;

/**
 * Class responsible for controlling a text processing
 */
public class TextService {

    private TextService() {
    }

    /**
     * Method responsible for start a text process
     *
     * @param fileName this string contains a file name of a text that will be processed
     */
    public static void processText(final String fileName) {
        final var text = ReadText.readText(fileName);

        if (StringUtils.isNotBlank(text)) {
            final var textList = FormatText.splitAndFormatText(text);
            final var adjacencyLists = OrdenateList.ordinateList(textList);

            CreateCSVFIle.createCSVFile(adjacencyLists, fileName);
            System.out.println("File " + fileName + ".txt processed successfully\n");
        } else {
            System.err.println("Could not complete processing for file: " + fileName + ".txt\n");
        }
    }
}
