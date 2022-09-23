package com.mycompany.projetopoo.usecase;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class responsible for format a text
 */
public class FormatText {

    private FormatText() {
    }

    /**
     * Method responsible for format a text -> format all text to lowercase, remove punctuation and turn a text into a string list
     *
     * @param text this string contains a text of a file that was read
     * @return returns a string list from the words in the text
     */
    public static List<String> splitAndFormatText(final String text) {
        final var formatedText = formatText(text);

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
