package app.decathlon.model;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class DecathlonAthleteResult {
    private HashMap<String, Double> results = new LinkedHashMap<>(10);
    private String name;
    private Integer total;
    private String place;

    public void putResult(String key, Double value) {
        results.put(key, value);
    }

    public Double getResult(String key){
        return results.get(key);
    }

    public HashMap<String, Double> getResults() {
        return results;
    }

    public void setResults(HashMap<String, Double> results) {
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
