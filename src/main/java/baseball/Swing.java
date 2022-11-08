package baseball;

public enum Swing {
    STRIKE("스트라이트"),
    BALL("볼");

    private final String swing;

    Swing(String swing) {
        this.swing = swing;
    }

    public String getSwing() {
        return swing;
    }
}