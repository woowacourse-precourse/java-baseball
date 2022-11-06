package baseball.domain.player;

public abstract class Player {
    public int number;
    public abstract void getNumber() throws IllegalArgumentException;
}
