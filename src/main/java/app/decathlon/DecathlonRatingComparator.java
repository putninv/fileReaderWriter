package app.decathlon;

import app.decathlon.model.DecathlonAthleteResult;

import java.util.Comparator;

public class DecathlonRatingComparator implements Comparator<DecathlonAthleteResult> {

    @Override
    public int compare(DecathlonAthleteResult res1, DecathlonAthleteResult res2) {
        if(res1.getTotal() < res2.getTotal()) return 1;
        if(res1.getTotal() > res2.getTotal()) return -1;
        else return 0;
    }
}
