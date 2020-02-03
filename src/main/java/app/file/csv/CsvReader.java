package app.file.csv;

import app.decathlon.model.DecathlonAthleteResult;
import app.decathlon.model.DecathlonEvent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public List<DecathlonAthleteResult> readDecathlonResults(String csvFilePath) {
        BufferedReader br = null;
        String row = null;
        String cvsSplitBy = ";";
        DecathlonAthleteResult result;
        List<DecathlonAthleteResult> results;
        try {
            br = new BufferedReader(new FileReader(csvFilePath));
            results = new ArrayList();
            while ((row = br.readLine()) != null && !row.isEmpty()) {
                result = new DecathlonAthleteResult();
                String[] rowData = row.split(cvsSplitBy);
                result.setName(rowData[0]);

                for(DecathlonEvent event : DecathlonEvent.values()) {
                    String value = rowData[event.getOrder()];
                    value = value.replaceAll("\\s+","");

                    if(event.getAlias().equals(DecathlonEvent.THOUSAND_AND_HALF_METERS.getAlias())) {
                        result.putResult(event.getAlias(), parseThousandHalfData(value));
                    } else{
                        result.putResult(event.getAlias(), Double.valueOf(value));
                    }
                }
                results.add(result);
            }
            return results;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private double parseThousandHalfData(String data){
        String[] times = data.split("\\.");
        long secondsInMinutes = Long.valueOf(times[0])*60;
        long seconds = Long.valueOf(times[1]);
        double secondsOfMilleSeconds = Long.valueOf(times[2])/1000;
        return secondsInMinutes + seconds + secondsOfMilleSeconds;
    }
}
