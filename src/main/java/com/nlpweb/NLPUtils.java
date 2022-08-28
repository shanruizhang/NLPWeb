package com.nlpweb;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The Class NLPUtils.
 */
public class NLPUtils {

    /** The Constant tagMeaningMap. */
    private static final Map<String, String> tagMeaningMap = new HashMap<>();

    static {
        tagMeaningMap.put("CC", "coordinating conjunction");
        tagMeaningMap.put("CD", "cardinal digit");
        tagMeaningMap.put("DT", "determiner");
        tagMeaningMap.put("EX", "existential there");
        tagMeaningMap.put("FW", "foreign word");
        tagMeaningMap.put("IN", "preposition/subordinating conjunction");
        tagMeaningMap.put("JJ", "adjective");
        tagMeaningMap.put("JJR", "adjective, comparative");
        tagMeaningMap.put("JJS", "adjective, superlative");
        tagMeaningMap.put("LS", "list market");
        tagMeaningMap.put("MD", "modal");
        tagMeaningMap.put("NN", "noun, singular");
        tagMeaningMap.put("NNS", "noun plural");
        tagMeaningMap.put("NNP", "proper noun, singular");
        tagMeaningMap.put("NNPS", "proper noun, plural");
        tagMeaningMap.put("PDT", "predeterminer ");
        tagMeaningMap.put("POS", "possessive ending ");
        tagMeaningMap.put("PRP", "personal pronoun");
        tagMeaningMap.put("PRP$", "possessive pronoun");
        tagMeaningMap.put("RB", "adverb");
        tagMeaningMap.put("RBR", "adverb, comparative");
        tagMeaningMap.put("RBS", "adverb, superlative");
        tagMeaningMap.put("RP", "particle ");
        tagMeaningMap.put("TO", "infinite marker");
        tagMeaningMap.put("UH", "interjection");
        tagMeaningMap.put("VB", "verb");
        tagMeaningMap.put("VBG", "verb gerund");
        tagMeaningMap.put("VBD", "verb past tense");
        tagMeaningMap.put("VBN", "verb past participle");
        tagMeaningMap.put("VBP", "verb, present tense not 3rd person singular");
        tagMeaningMap.put("VBZ", "verb, present tense with 3rd person singular");
        tagMeaningMap.put("WDT", "wh-determiner");
        tagMeaningMap.put("WP", "wh- pronoun");
        tagMeaningMap.put("WRB", "wh- adverb");
    }


    /**
     * Gets the available tags.
     *
     * @return the available tags
     */
    public static Set<String> getAvailableTags() {
        return tagMeaningMap.keySet();
    }

    /**
     * Gets the tag meaning.
     *
     * @param tag the tag
     * @return the tag meaning
     */
    public static String getTagMeaning(String tag) {
        if (tagMeaningMap.containsKey(tag)) {
            return tagMeaningMap.get(tag);
        }
        return tag;
    }

    /**
     * Read text file.
     *
     * @param filepath the filepath
     * @return the string
     */
    public static String readTextFile(String filepath) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Scanner scanner = new Scanner(new File(filepath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            scanner.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Initialize NLP.
     */
    public static void initializeNLP() {
        // set up pipeline properties
        Properties props = new Properties();
        // set the list of annotators to run
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote");
        // set a property for an annotator, in this case the coref annotator is being set to use the neural algorithm
        props.setProperty("coref.algorithm", "neural");
        // build pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    }

    /**
     * Read document.
     *
     * @param text the text
     * @return the core document
     */
    public static CoreDocument readDocument(String text) {
        // set up pipeline properties
        Properties props = new Properties();
        // set the list of annotators to run
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,depparse,coref,kbp,quote");
        // set a property for an annotator, in this case the coref annotator is being set to use the neural algorithm
        props.setProperty("coref.algorithm", "neural");
        // build pipeline
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        // create a document object
        CoreDocument document = new CoreDocument(text);
        // annotate the document
        pipeline.annotate(document);
        return document;
    }


}
