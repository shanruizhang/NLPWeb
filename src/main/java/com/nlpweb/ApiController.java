package com.nlpweb;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class ApiController.
 */
@RestController
public class ApiController {

    /**
     * Analysis text web api.
     *
     * @param text the input text for analysis
     * @return the analysis result
     */
    @PostMapping("/analysis")
    public AnalysisResult analysis(@RequestParam(value = "text", defaultValue = "") String text) {
        // create a document
        DocumentStatistics documentStatistics = new DocumentStatistics(text);
        // process text analysis
        documentStatistics.processDocument();
        // return result
        return new AnalysisResult(documentStatistics.getSentenceCount(), documentStatistics.getTokensCount(), documentStatistics.getNounsCount(), documentStatistics.getTagCountMap());
    }
}
