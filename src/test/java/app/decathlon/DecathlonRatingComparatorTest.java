package app.decathlon;

import app.decathlon.model.DecathlonAthleteResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class DecathlonRatingComparatorTest {

    @Test
    public void compareTest() {
        List<DecathlonAthleteResult> expected = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            expected.add(new DecathlonAthleteResult());
        }
        expected.get(0).setTotal(10);
        expected.get(1).setTotal(20);
        expected.get(2).setTotal(30);
        expected.get(3).setTotal(40);

        List<DecathlonAthleteResult> forCheck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            forCheck.add(new DecathlonAthleteResult());
        }
        forCheck.get(0).setTotal(40);
        forCheck.get(1).setTotal(20);
        forCheck.get(2).setTotal(30);
        forCheck.get(3).setTotal(10);
        Collections.sort(forCheck, Collections.reverseOrder(new DecathlonRatingComparator()));

        for (int i = 0; i < 4; i++) {
            assertEquals(expected.get(i).getTotal(), forCheck.get(i).getTotal());
        }
    }
}
