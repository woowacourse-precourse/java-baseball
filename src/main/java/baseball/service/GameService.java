package baseball.service;

import baseball.model.GameResult;
import baseball.util.GameNumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class GameService {

    private static GameService instance = new GameService();
    private String gameNumber;

    public void setGameNumber(String gameNumber) {
        this.gameNumber = gameNumber;
    }

    private GameService() {
    }

    public static GameService getInstance() {
        return instance;
    }

    public GameResult judge(String playerInput) {
        return new GameResult(calcBall(playerInput), calcStrike(playerInput));
    }


    private int calcBall(String playerInput) {
        Set<Character> inputNumberList = new HashSet<>();
        int ball = 0;
        for (int i = 0; i < gameNumber.length(); i++) {
            inputNumberList.add(gameNumber.charAt(i));
        }
        for (int i = 0; i < playerInput.length(); i++) {
            if (playerInput.charAt(i) != gameNumber.charAt(i) &&
                    inputNumberList.contains(playerInput.charAt(i))) {
                ball++;
            }
        }
        return ball;
    }

    private int calcStrike(String playerInput) {
        int strike = 0;
        for (int i = 0; i < gameNumber.length(); i++) {
            if (playerInput.charAt(i) == gameNumber.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    public String createNumber() {
        gameNumber = GameNumberGenerator.createGameNumber();
        return gameNumber;
    }
}
