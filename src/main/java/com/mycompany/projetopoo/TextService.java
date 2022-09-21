/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projetopoo;

import com.mycompany.projetopoo.usecase.CreateCSVFIle;
import com.mycompany.projetopoo.usecase.FormatText;
import com.mycompany.projetopoo.usecase.OrdenateList;
import com.mycompany.projetopoo.usecase.ReadText;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author t247602
 */
public class TextService {

    public static void main(final String[] args) {
        final var listFileNames = read();

        listFileNames.forEach(TextService::processText);
    }

    private static void processText(final String fileName) {
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

    private static List<String> read() {
        final List<String> list = new ArrayList<>();
        final Scanner scanner = new Scanner(System.in);
        var fileName = "";
        while (!"stop".equalsIgnoreCase(fileName)) {
            System.out.println("Write a file name or 'stop' to stop:");
            fileName = scanner.next();
            if (!fileName.equalsIgnoreCase("stop")) {
                list.add(fileName);
            }
        }
        System.out.println();
        scanner.close();
        return list;
    }
}
