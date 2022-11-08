package baseball;

import baseball.constants.SystemConsole;
import baseball.domain.GameResultScore;
import baseball.domain.RandomGenerator;

import java.util.List;

import static baseball.domain.GameResultScore.getRestart;

public class BaseballGame {
    private static final String RESTART = "1";
    private static final String GAME_WIN_CONDITIONS = "3스트라이크";

    private final RandomGenerator randomGenerator;
    private final SystemConsole systemConsole;
    private final GameResultScore gameResultScore;

    public BaseballGame(RandomGenerator randomGenerator, SystemConsole systemConsole, GameResultScore gameResultScore) {
        this.randomGenerator = randomGenerator;
        this.systemConsole = systemConsole;
        this.gameResultScore = gameResultScore;
    }

    public void start() {
        systemConsole.baseballStartMessage();
        conditionsBaseballGame();
    }

    public void conditionsBaseballGame() {
        String restartNumber = "1";

        while (restartNumber.equals(RESTART)) {
            List<Integer> computer = randomGenerator.createRandomNumbers();
            guessComputerNumbers(computer);
            restartNumber = getRestart();
        }
    }

    public void guessComputerNumbers(List<Integer> computer) {
        String gameResultNumber = "";

        while (!(gameResultNumber.equals(GAME_WIN_CONDITIONS))) {
            systemConsole.PlayerInputMessage();
            gameResultNumber = gameResultScore.getGameNumber(computer);
            systemConsole.gameResultNumberMessage(gameResultNumber);
        }
    }
}
