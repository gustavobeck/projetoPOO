package com.mycompany.projetopoo.usecase;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatText {

    private FormatText() {
    }

    public static List<String> splitAndFormatText(final String fileName) {
        final var formatedText = formatText(fileName);

        return splitWords(formatedText);
    }

    private static String formatText(final String text) {
        return text.replaceAll("\\p{Punct}", "")
                .toLowerCase();
    }

    private static List<String> splitWords(final String text) {
        return Stream.of(StringUtils.split(text))
                .collect(Collectors.toList());
    }
}
