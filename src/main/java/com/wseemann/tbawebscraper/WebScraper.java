package com.wseemann.tbawebscraper;

import com.wseemann.tbawebscraper.models.BracketWithCompetitors;

import java.io.IOException;
import java.util.List;

public interface WebScraper {
    List<BracketWithCompetitors> scrape(String url) throws IOException, NumberFormatException;
}
