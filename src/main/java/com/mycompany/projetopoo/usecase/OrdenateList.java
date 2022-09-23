package com.mycompany.projetopoo.usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class responsible for ordenate a text into an adjacency list map
 */
public class OrdenateList {

    private OrdenateList() {
    }

    /**
     * Method responsible for convert the string list of words in a map where: key = adjacency list and value = destination words list
     *
     * @param list this list contains all the words from the text read
     * @return returns a adjacency list map
     */
    public static Map<String, List<String>> ordinateList(final List<String> list) {
        final var words = new HashMap<String, List<String>>();
        final var alphabeticList = sortAndRemoveDuplicatedWords(list);

        alphabeticList.forEach(word -> {
            final var nextWordList = new ArrayList<String>();
            final var indices = findIndices(list, word);
            indices.forEach(i -> nextWordList.add(findNextWord(list, i + 1)));

            words.put(word, removeDuplicatedWords(nextWordList));
        });

        return new TreeMap<>(words);
    }

    private static List<String> sortAndRemoveDuplicatedWords(final List<String> list) {
        final Set<String> set = new TreeSet<>(list);
        return new ArrayList<>(set);
    }

    private static List<String> removeDuplicatedWords(final List<String> list) {
        final Set<String> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    private static List<Integer> findIndices(final List<String> list, final String word) {
        return IntStream.range(0, list.size())
                .filter(i -> word.equals(list.get(i)))
                .boxed().collect(Collectors.toList());
    }

    private static String findNextWord(final List<String> list, final Integer index) {
        if (index > list.size() - 1) {
            return list.get(0);
        }
        return list.get(index);
    }
}