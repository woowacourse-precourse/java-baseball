package baseball.domain.player;

public abstract class Player {

    public int number;

    public abstract void getNumber() throws IllegalArgumentException;

    public void checkLengthOfInput(String s) {
    }

    public void checkDuplicationOfInput(int[] arrInput) {
    }
}
