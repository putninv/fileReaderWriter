package app.file.csv;

import app.decathlon.model.DecathlonAthleteResult;
import app.decathlon.model.DecathlonEvent;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CsvReaderTest {

    @Test
    public void readDecathlonResultsTest() {
        String csvFile = "src/main/resources/results.csv";
        List<DecathlonAthleteResult> results = new CsvReader().readDecathlonResults(csvFile);
        DecathlonAthleteResult result = results.get(0);

        Double val0 = result.getResults().get(DecathlonEvent.HUNDRED_METERS.getAlias());
        Double val1 = result.getResults().get(DecathlonEvent.LONG_JUMP.getAlias());
        Double val2 = result.getResults().get(DecathlonEvent.SHOT_PUT.getAlias());
        Double val3 = result.getResults().get(DecathlonEvent.HIGH_JUMP.getAlias());
        Double val4 = result.getResults().get(DecathlonEvent.FOUR_HUNDRED_METERS.getAlias());
        Double val5 = result.getResults().get(DecathlonEvent.HURDLES.getAlias());
        Double val6 = result.getResults().get(DecathlonEvent.DISCUS_THROW.getAlias());
        Double val7 = result.getResults().get(DecathlonEvent.POLE_VAULT.getAlias());
        Double val8 = result.getResults().get(DecathlonEvent.JAVELIN_THROW.getAlias());
        Double val9 = result.getResults().get(DecathlonEvent.THOUSAND_AND_HALF_METERS.getAlias());

        assertEquals(val0, new Double(12.61));
        assertEquals(val1, new Double(5.0));
        assertEquals(val2, new Double(9.22));
        assertEquals(val3, new Double(1.5));
        assertEquals(val4, new Double(60.39));
        assertEquals(val5, new Double(16.43));
        assertEquals(val6, new Double(21.6));
        assertEquals(val7, new Double(2.6));
        assertEquals(val8, new Double(35.81));
        assertEquals(val9, new Double(325.0));
    }
}
