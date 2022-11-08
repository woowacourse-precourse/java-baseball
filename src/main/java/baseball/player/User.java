package baseball.player;

public class User extends Player {

    @Override
    public void selectBalls() {

    }

    private boolean isSelectRightNumber(String userInput) {
        return userInput.length() == 3;
    }
}
