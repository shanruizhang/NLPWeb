package com.nlpweb;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;


public class NLPMain {

	public static void main(String[] args) throws FileNotFoundException, JsonProcessingException {
        String filename = "text.txt";
        // ask user enter a text file name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a text file name: ");
        filename = scanner.nextLine();
        System.out.println("Please enter output file name: ");
        String outfilename = scanner.nextLine();

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
        
        PrintWriter printWriter = new PrintWriter(outfilename);
        JsonMapper jsonMapper = new JsonMapper();
        AnalysisResult result = new AnalysisResult(documentStatistics.getSentenceCount(), documentStatistics.getTokensCount(), documentStatistics.getNounsCount(), documentStatistics.getTagCountMap());
        printWriter.println(jsonMapper.writeValueAsString(result));
        printWriter.flush();
        printWriter.close();
    }
}
