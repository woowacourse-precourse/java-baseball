package baseball;

import java.util.Objects;

public class RestartGameOrNot {
    private final int userChoice;
    public RestartGameOrNot(String whetherNewGame){
        validateWhetherNewGame(whetherNewGame);
        userChoice = whetherNewGame.charAt(0) - '0';
    }

    private void validateWhetherNewGame(String whetherNewGame) {
        if (!Objects.equals(whetherNewGame, "1") && !Objects.equals(whetherNewGame, "2")) {
            throw new IllegalArgumentException("userInput should be 1 or 2.");
        }
    }

    public boolean gameover(){
        return userChoice == 2;
    }
}
