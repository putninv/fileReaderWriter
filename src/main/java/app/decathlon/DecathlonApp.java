package app.decathlon;

import app.decathlon.model.DecathlonAthleteResult;
import app.file.csv.CsvReader;
import app.file.xml.XmlWriter;

import java.util.Collections;
import java.util.List;

public class DecathlonApp {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/results.csv";
        String xmlFilePath = "src/main/resources/out.xml";
        List<DecathlonAthleteResult> results = new CsvReader().readDecathlonResults(csvFile);
        for(DecathlonAthleteResult result : results) {
            DecathlonScoreCalculator.calcTotal(result);
        }
        Collections.sort(results, new DecathlonRatingComparator());
        DecathlonScoreCalculator.calcPlaces(results);
        XmlWriter.writeDecathlonResults(results, xmlFilePath);
    }
}
