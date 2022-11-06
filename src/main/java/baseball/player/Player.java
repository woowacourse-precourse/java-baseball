package baseball.player;

public class Player {

    private final int number;

    protected Player(int number) {
        this.number = number;
    }

    protected int getNumber() {
        return number;
    }
}
