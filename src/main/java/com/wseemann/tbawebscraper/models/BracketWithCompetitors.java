package com.wseemann.tbawebscraper.models;

import java.util.List;

public class BracketWithCompetitors {

    private Bracket bracket;
    private List<Competitor> competitors;

    public BracketWithCompetitors(Bracket bracket, List<Competitor> competitors) {
        this.bracket = bracket;
        this.competitors = competitors;
    }

    public Bracket getBracket() {
        return bracket;
    }

    public void setBracket(Bracket bracket) {
        this.bracket = bracket;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }
}
