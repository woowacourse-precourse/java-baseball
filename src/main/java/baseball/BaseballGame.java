package baseball;

import baseball.constants.SystemConsole;
import baseball.domain.GameResultScore;
import baseball.domain.RandomGenerator;
import baseball.player.Player;

import java.util.List;

import static baseball.domain.GameResultScore.getRestart;

public class BaseballGame {
    private static final String RESTART = "1";
    private static final String GAME_WIN_CONDITIONS = "3스트라이크";

    private final SystemConsole systemConsole;
    private final GameResultScore gameResultScore;

    public BaseballGame(SystemConsole systemConsole, GameResultScore gameResultScore) {
        this.systemConsole = systemConsole;
        this.gameResultScore = gameResultScore;
    }

    public void start() {
        Player player = new Player();
        RandomGenerator randomGenerator = new RandomGenerator();

        systemConsole.baseballStartMessage();
        conditionsBaseballGame(player, randomGenerator);
    }

    public void conditionsBaseballGame(Player player, RandomGenerator randomGenerator) {
        String restartNumber = "1";

        while (restartNumber.equals(RESTART)) {
            List<Integer> computer = randomGenerator.createRandomNumbers();
            guessComputerNumbers(player, computer);
            restartNumber = getRestart();
        }
    }

    public void guessComputerNumbers(Player player, List<Integer> computer) {
        String gameResultNumber = "";

        while (!(gameResultNumber.equals(GAME_WIN_CONDITIONS))) {
            systemConsole.PlayerInputMessage();
            gameResultNumber = gameResultScore.getGameNumber(player, computer);
            systemConsole.gameResultNumberMessage(gameResultNumber);
        }
    }
}
