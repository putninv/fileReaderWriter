package app.decathlon;

import app.decathlon.model.DecathlonAthleteResult;
import app.decathlon.model.DecathlonEvent;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DecathlonScoreCalculatorTest {

    @Test
   public void calcPlacesTest() {
        List<DecathlonAthleteResult> results = new ArrayList<>();
        for(int i =0; i < 4; i++){
            results.add(new DecathlonAthleteResult());
        }

        results.get(0).setTotal(20);
        results.get(1).setTotal(30);
        results.get(2).setTotal(30);
        results.get(3).setTotal(40);
        DecathlonScoreCalculator.calcPlaces(results);
        assertEquals(results.get(0).getPlace(), "1");
        assertEquals(results.get(1).getPlace(), "2-3");
        assertEquals(results.get(2).getPlace(), "2-3");
        assertEquals(results.get(3).getPlace(), "4");
    }

    @Test
   public void calcTotalTest() {
        DecathlonAthleteResult result = new DecathlonAthleteResult();
        for(DecathlonEvent event : DecathlonEvent.values()) {
            result.putResult(event.getAlias(), 13.54);
        }

        DecathlonScoreCalculator.calcTotal(result);
        Integer res = result.getTotal();
        assertEquals(res, new Integer(40938953));
    }
}
