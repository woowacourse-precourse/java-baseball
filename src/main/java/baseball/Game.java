package baseball;

import static Config.BaseResponseStatus .*;
import camp.nextstep.edu.missionutils.Console;
public class Game {
    private final GamePlayer gamePlayer;
    private final ComputerOfGame computerOfGame;
    private final ValidatorOfInputValue validatorOfInputValue;
    private Integer gameStatus;

    public Game(GamePlayer gamePlayer, ComputerOfGame computerOfGame) {
        this.gamePlayer = gamePlayer;
        this.computerOfGame = computerOfGame;
        this.validatorOfInputValue = new ValidatorOfInputValue();
        this.gameStatus = PLAY;
    }

    public void start() {
        UserScoreOfGame userScoreOfGame = new UserScoreOfGame();
        while (gameStatus == PLAY) {
            computerOfGame.makeAnswer();
            while (!userScoreOfGame.isAllStrike()) {
                gamePlayer.setUserNumber();
                userScoreOfGame.countScore(computerOfGame, gamePlayer);
                System.out.println(userScoreOfGame.scoreString());
            }
            getGameStatus();
        }
    }

    private void getGameStatus() {
        System.out.println(SUCCESS_MESSAGE);
        System.out.println(RESTART_OR_TERMINATE_MESSAGE);
        String userInputStatus = Console.readLine();
        if (!validatorOfInputValue.checkUserInputStatus(userInputStatus)) {
            throw new IllegalArgumentException(INVALID_RESTART_OR_TERMINATE_INPUT_ERROR);
        }
        gameStatus = Integer.parseInt(userInputStatus);
    }
}
