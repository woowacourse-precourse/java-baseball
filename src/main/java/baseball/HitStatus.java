package baseball;

public enum HitStatus {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");
    private final String name;

    HitStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}