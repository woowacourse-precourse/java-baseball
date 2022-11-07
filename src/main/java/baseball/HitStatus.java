package baseball;

public enum HitStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String name;

    HitStatus(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
