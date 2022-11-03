package baseball.domain;

public class BallIndex {
    private final int ballIndex;

    public BallIndex(int ballIndex) {
        this.ballIndex = ballIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallIndex ballIndex1 = (BallIndex) o;
        return ballIndex == ballIndex1.ballIndex;
    }
}
