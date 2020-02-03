package app.decathlon;

import app.decathlon.model.DecathlonAthleteResult;
import app.decathlon.model.DecathlonEvent;

import java.util.List;

public class DecathlonScoreCalculator {

    public static void calcPlaces(List<DecathlonAthleteResult> results) {
        int[] res = new int[results.size()];

        for(int i = results.size()-1; i >= 0; i--) {
            for (int n = i; n >= 0; n--) {
                if (results.get(i).getTotal().equals(results.get(n).getTotal())) {
                    res[n] = i;
                    i=n;
                } else {
                    break;
                }
            }
        }

        for(int i = 0; i < res.length; i++) {
            int c = res[i];
            StringBuilder place = new StringBuilder();
            for(int n = i; n <= c; n++) {
                if(n == i){
                    place.append(n + 1);
                } else {
                    place.append("-").append(n+1);
                }

            }
            for(int n = i; n <= c; n++) {
                results.get(n).setPlace(place.toString());
                i=n;
            }
        }
    }

    public static void calcTotal(DecathlonAthleteResult result) {
        double total = 0.0;
        for (DecathlonEvent event : DecathlonEvent.values()) {
            Double value = result.getResult(event.getAlias());

            if (event.getSecondsUnit()) {
                total += calcTrackEvent(value, event.getParameterA(), event.getParameterB(), event.getParameterC());
            } else {
                total += calcFieldEvent(value, event.getParameterA(), event.getParameterB(), event.getParameterC());
            }
        }
        result.setTotal((int)total);
    }


    private static Double calcTrackEvent(Double p, Double a, Double b, Double c) {
        if (p == null || a == null || b == null || c == null) {
            return null;
        }
        double x = Math.abs(b - p);
        double y = Math.pow(x, c);
        double z = x * y;
        return z;
    }

    private static Double calcFieldEvent(Double p, Double a, Double b, Double c) {
        if (p == null || a == null || b == null || c == null) {
            return null;
        }
        double x = Math.abs(p - b);
        double y = Math.pow(x, c);
        double z = x * y;
        return z;
    }

}
