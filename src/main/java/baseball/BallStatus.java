package baseball;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public boolean isNotNothing() {
        return !this.equals(NOTHING);
    }
}
