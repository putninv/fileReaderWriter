package app.decathlon.model;

public enum DecathlonEvent {
    HUNDRED_METERS(1, "hundredMDash", true,25.4347, 18.0, 1.81),
    LONG_JUMP (2, "LongJump", false,0.14354, 220.0, 1.4),
    SHOT_PUT  (3,"ShotPut", false,51.39, 1.5, 1.05),
    HIGH_JUMP  (4,"HighJump", false,0.8465, 75.0, 1.42),
    FOUR_HUNDRED_METERS  (5,"fourHundredMDash", true,1.53775, 82.0, 1.81),
    HURDLES (6,"hundredTenMHurdles", true,5.74352, 28.5, 1.92),
    DISCUS_THROW (7,"DiscusThrow", false,12.91, 4.0, 1.1),
    POLE_VAULT  (8,"PoleVault", false,0.2797, 100.0, 1.35),
    JAVELIN_THROW (9,"JavelinThrow", false,10.14, 7.0, 1.08),
    THOUSAND_AND_HALF_METERS (10,"thousandAndHalfM", true, 0.03768, 480.0, 1.85);

    Integer order;
    String alias;
    Boolean secondsUnit;
    Double parameterA;
    Double parameterB;
    Double parameterC;

    DecathlonEvent(Integer order, String alias, Boolean secondsUnit, Double a, Double b, Double c){
        this.order = order;
        this.alias = alias;
        this.secondsUnit = secondsUnit;
        this.parameterA = a;
        this.parameterB = b;
        this.parameterC = c;
    }

    public Integer getOrder() {
        return order;
    }

    public String getAlias() {
        return alias;
    }

    public Boolean getSecondsUnit() {
        return secondsUnit;
    }

    public Double getParameterA() {
        return parameterA;
    }

    public Double getParameterB() {
        return parameterB;
    }

    public Double getParameterC() {
        return parameterC;
    }

}
