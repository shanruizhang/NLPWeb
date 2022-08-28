package com.nlpweb;

import java.util.Map;
import java.util.Scanner;


public class NLPMain {

    public static void main(String[] args) {
        String filename = "text.txt";
        // ask user enter a text file name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a text file name: ");
        filename = scanner.nextLine();

        // read text content
        String text = NLPUtils.readTextFile(filename);
        // create a DocumentStatistics
        DocumentStatistics documentStatistics = new DocumentStatistics(text);
        // process analysis
        documentStatistics.processDocument();

        // print analysis result
        System.out.println("Document statistics");
        System.out.printf("Sentence Count: %d\n", documentStatistics.getSentenceCount());
        System.out.printf("Token Count: %d\n", documentStatistics.getTokensCount());
        System.out.printf("Nouns Count: %d\n", documentStatistics.getNounsCount());

        // print tags detail
        Map<String, Integer> tagCount = documentStatistics.getTagCountMap();
        System.out.println();
        System.out.println("All tags count");
        for (String tag : tagCount.keySet()) {
            int count = tagCount.get(tag);
            if (count > 0 && NLPUtils.getAvailableTags().contains(tag)) {
                String meaning = NLPUtils.getTagMeaning(tag);
                System.out.printf("%s (%s): %d\n", tag, meaning, count);
            }
        }
    }
}
