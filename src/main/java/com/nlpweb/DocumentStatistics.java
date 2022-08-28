package com.nlpweb;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Class DocumentStatistics.
 */
public class DocumentStatistics {
    
    /** The document. */
    private CoreDocument document;
    
    /** The text. */
    private String text;

    /** The sentence count. */
    private int sentenceCount;
    
    /** The tokens count. */
    private int tokensCount;
    
    /** The nouns count. */
    private int nounsCount;
    
    /** The tag count map. */
    private Map<String, Integer> tagCountMap;

    /**
     * Instantiates a new document statistics.
     *
     * @param text the text
     */
    public DocumentStatistics(String text) {
        this.text = text;
    }

    /**
     * Process document.
     */
    public void processDocument() {
        document = NLPUtils.readDocument(text);
        List<CoreSentence> sentences = document.sentences();
        List<CoreLabel> tokens = document.tokens();
        sentenceCount = sentences.size();
        tokensCount = tokens.size();
        nounsCount = 0;
        tagCountMap = new HashMap<>();
        for (CoreLabel token : tokens) {
            String tag = token.tag();
            if (tag.startsWith("NN")) {
                nounsCount++;
            }
            if (!tagCountMap.containsKey(tag)) {
                tagCountMap.put(tag, 0);
            }
            tagCountMap.put(tag, tagCountMap.get(tag) + 1);
        }
    }

    /**
     * Gets the sentence count.
     *
     * @return the sentence count
     */
    public int getSentenceCount() {
        return sentenceCount;
    }

    /**
     * Gets the tokens count.
     *
     * @return the tokens count
     */
    public int getTokensCount() {
        return tokensCount;
    }

    /**
     * Gets the nouns count.
     *
     * @return the nouns count
     */
    public int getNounsCount() {
        return nounsCount;
    }

    /**
     * Gets the tag count map.
     *
     * @return the tag count map
     */
    public Map<String, Integer> getTagCountMap() {
        Map<String, Integer> result = new TreeMap<>();
        for (String tag : tagCountMap.keySet()) {
            int count = tagCountMap.get(tag);
            if (NLPUtils.getAvailableTags().contains(tag)) {
                result.put(tag, count);
            }
        }
        return result;
    }
}
