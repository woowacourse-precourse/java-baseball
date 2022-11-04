package baseball;

public class Player {
    private Baseballs input;

    public Player() {
    }

    public void initMyAnswerBy(String playerInput) {
        this.input = Baseballs.of(playerInput);
    }
}
