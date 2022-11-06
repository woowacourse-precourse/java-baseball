package baseball;

import baseball.constants.SystemConsole;
import baseball.constants.SystemMessage;
import baseball.domain.RandomGenerator;
import baseball.domain.Referee;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    private static final String RESTART = "1";
    private static final String PATTERN = "[1-2]+";
    private static final String GAME_WIN_CONDITIONS = "3스트라이크";
    private static final String RESTART_INPUT = "플레이어가 숫자 1 또는 2가 아닌 다른 값을 입력하였습니다.";

    private final SystemConsole systemConsole;

    public BaseballGame(SystemConsole systemConsole) {
        this.systemConsole = systemConsole;
    }

    public void start() {
        Player player = new Player();
        Referee referee = new Referee();
        RandomGenerator randomGenerator = new RandomGenerator();

        systemConsole.baseballStartMessage();
        conditionsBaseballGame(player, referee, randomGenerator);
    }

    private void conditionsBaseballGame(Player player, Referee referee, RandomGenerator randomGenerator) {
        String restartNumber = "1";

        while (restartNumber.equals(RESTART)) {
            List<Integer> computer = randomGenerator.createRandomNumbers();
            guessComputerNumbers(player, referee, computer);
            restartNumber = getRestart();
        }
    }

    private void guessComputerNumbers(Player player, Referee referee, List<Integer> computer) {
        String gameResultNumber = "";

        while (!(gameResultNumber.equals(GAME_WIN_CONDITIONS))) {
            systemConsole.PlayerInputMessage();
            gameResultNumber = getGameResultNumber(player, referee, computer);
            systemConsole.gameResultNumberMessage(gameResultNumber);
        }
    }

    private String getGameResultNumber(Player player, Referee referee, List<Integer> computer) {
        String gameResultNumber;
        List<Integer> playerInput = getPlayerInput(player);
        gameResultNumber = referee.resultJudgment(computer, playerInput);
        return gameResultNumber;
    }

    private List<Integer> getPlayerInput(Player player) {
        String playerNumber = Console.readLine();
        return player.getInput(playerNumber);
    }

    private static String playerRestartInput() {
        String restart = Console.readLine();
        if (!(restart.matches(PATTERN))) {
            throw new IllegalArgumentException(RESTART_INPUT);
        }
        return restart;
    }

    public static String getRestart() {
        SystemConsole.gameWinMessage();
        SystemConsole.gameRestartMessage();
        return playerRestartInput();
    }
}
