package com.nlpweb;

import java.util.Map;
import java.util.TreeMap;

/**
 * A json object return to web browser.
 */
public class AnalysisResult {

    /** The sentence count. */
    private int sentenceCount;
    
    /** The tokens count. */
    private int tokensCount;
    
    /** The nouns count. */
    private int nounsCount;
    
    /** The tag count map. */
    private Map<String, Integer> tagCountMap;

    /**
     * Instantiates a new analysis result.
     *
     * @param sentenceCount the sentence count
     * @param tokensCount the tokens count
     * @param nounsCount the nouns count
     * @param tagCountMap the tag count map
     */
    public AnalysisResult(int sentenceCount, int tokensCount, int nounsCount, Map<String, Integer> tagCountMap) {
        this.sentenceCount = sentenceCount;
        this.tokensCount = tokensCount;
        this.nounsCount = nounsCount;
        this.tagCountMap = tagCountMap;
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
        return new TreeMap<>(tagCountMap);
    }

}
