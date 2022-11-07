package baseball;

public enum BallStatus {
    STRIKE("strike"), BALL("ball");
    public final String status;
    BallStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
