package com.mycompany.projetopoo.controller;

import com.mycompany.projetopoo.service.TextService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class responsible start the program
 */
public class TextController {

    /**
     * Method responsible for receiving texts file names and start the program
     */
    public static void main(final String[] args) {
        final var listFileNames = read();

        listFileNames.forEach(TextService::processText);
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
