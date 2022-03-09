package com.wseemann.tbawebscraper;

import com.wseemann.tbawebscraper.models.Bracket;
import com.wseemann.tbawebscraper.models.BracketWithCompetitors;
import com.wseemann.tbawebscraper.models.Competitor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraperImpl implements WebScraper {

    private Bracket bracket;
    private ArrayList<Competitor> competitors;

    public WebScraperImpl() {

    }

    @Override
    public List<BracketWithCompetitors> scrape(String url) throws IOException, NumberFormatException {
        String division;
        String divisionName;

        List<BracketWithCompetitors> bracketWithCompetitorsList = new ArrayList<>();

        boolean skipRestOfBracket = false;

        Document doc = Jsoup.connect(url).get();
        //String title = doc.title();
        Element body = doc.body();
        Elements tableBody = body.select("tbody");

        if (tableBody.size() != 3) {
            throw new IllegalArgumentException("There are not three page tables");
        }

        Element bracketHeader = tableBody.get(1);
        Elements rows = bracketHeader.select("tr");
        String bracketName = rows.get(0).select("td").text();
        division = bracketName.substring(bracketName.indexOf("CLASS") + 6, bracketName.indexOf("CLASS") + 7);
        divisionName = bracketName.substring(0, bracketName.indexOf("DIVISION") + 8);

        Element competitorTable = tableBody.get(2);
        rows = competitorTable.select("tr");

        for (Element row : rows) {
            Elements columns = row.select("td");

            if (columnHasText("Weight", columns)) { // Parse Weight Class
                skipRestOfBracket = false;
                bracket = new Bracket();
                bracket.setBracketClass(division);
                bracket.setName(divisionName);
                System.out.println(division);
                System.out.println(divisionName);
                competitors = new ArrayList<>();

                String columnText = columns.text();
                //int index = columnText.indexOf("Weight");
                int index = columnText.lastIndexOf(" ");
                //bracket.setName(columnText.substring(0, index + 6));
                //String weight = columnText.substring(index + 7).trim();
                bracket.setName(columnText.substring(0, index));
                String weight = columnText.substring(index).trim();

                if (weight.contains("and Under")) {
                    String[] weightClass = weight.split("and");
                    bracket.setUpperWeight(Double.parseDouble(weightClass[0]));
                } else if (weight.contains("and Above")) {
                    String[] weightClass = weight.split("and");
                    bracket.setLowerWeight(Double.parseDouble(weightClass[0]));
                } else if (weight.contains("-")) {
                    String[] weightClass = weight.split("-");
                    bracket.setLowerWeight(Double.parseDouble(weightClass[0]));
                    bracket.setUpperWeight(Double.parseDouble(weightClass[1]));
                }

                System.out.println(bracket);
            } else if (columnHasText("Fully Registered", columns)) { // Parse Registered Fighters
                // no-op
            } else if (columnHasText("Pending Registrations", columns)) { // Parse Pending Fighters
                skipRestOfBracket = true;

                if (bracket != null) {
                    bracketWithCompetitorsList.add(new BracketWithCompetitors(bracket, competitors));
                }
            } else if (!skipRestOfBracket) {
                parseRegisteredFighters(columns);
            }
        }

        return bracketWithCompetitorsList;
    }

    private void parseRegisteredFighters(Elements columns) {
        for (Element column : columns) {
            if (column.hasText() &&
                    !column.text().isBlank() &&
                    !column.text().isEmpty() &&
                    !column.text().trim().equals(".")) { // Parse Registered Fighters Text
                String line = column.html().replaceAll("<br>", "\n").trim();
                String[] competitorInfo = line.split("\\n");
                int competitorInfoLength = competitorInfo.length;

                if (competitorInfoLength >= 4) {
                    String[] name = competitorInfo[0].split(" ");

                    Competitor competitor = new Competitor();
                    competitor.setFirstName(name[0].trim());
                    competitor.setLastName(name[1].trim());
                    competitor.setStats(competitorInfo[1].trim());
                    competitor.setRecord(competitorInfo[3].trim());
                    competitor.setGymName(competitorInfo[competitorInfoLength - 2].trim());

                    System.out.println(competitor);

                    competitors.add(competitor);
                }
            }
        }
    }

    private boolean columnHasText(String text, Elements column) {
        return column.text().contains(text);
    }
}
