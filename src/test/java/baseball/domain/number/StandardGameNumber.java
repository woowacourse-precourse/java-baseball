package baseball.domain.number;

public abstract class StandardGameNumber {

    protected final int number = 1;
    protected final int index = 1;
    protected final GameNumber standardGameNumber = new GameNumber(number, index);
}
