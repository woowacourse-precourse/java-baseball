package baseball;

import java.util.Objects;

public class Digit {

    private final Integer index;

    private final Integer digitNumber;

    public Digit(Integer index, Integer digitNumber) {
        this.index = index;
        this.digitNumber = digitNumber;
    }

    private ScoreStatus isBallOrStrikeOrNothing(final Digit trial){
        if (isStrike(trial)) {
            return ScoreStatus.STRIKE;
        }

        if (isBall(trial)) {
            return ScoreStatus.BALL;
        }
        return ScoreStatus.NOTHING;
    }

    private boolean isStrike(final Digit trial) {
        return this.equals(trial);
    }
    public boolean isBall(final Digit trial) {
        return this.digitNumber.equals(trial.digitNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, digitNumber);
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        final Digit trial = (Digit) object;
        return isSameValueTrial(trial);
    }

    private boolean isSameValueTrial(Digit trial) {
        return isEqualsIndex(trial) && isEqualsDigitNumber(trial);
    }

    private boolean isEqualsDigitNumber(Digit trial) {
        return Objects.equals(this.digitNumber, trial.digitNumber);
    }

    private boolean isEqualsIndex(Digit trial) {
        return Objects.equals(this.index, trial.index);
    }

    @Override
    public String toString() {
        return "Ball{ trialIndex=" + index +
                ", digitNumber=" + digitNumber +
                '}';
    }
}
