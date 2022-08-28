package com.nlpweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class NlpWebApplication.
 */
@SpringBootApplication
public class NlpWebApplication {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        NLPUtils.initializeNLP();
        SpringApplication.run(NlpWebApplication.class, args);
    }

}
