package baseball;

enum Ball {
    BALL("볼 "),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String name;

    Ball(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
