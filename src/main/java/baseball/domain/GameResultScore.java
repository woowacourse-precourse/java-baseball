package baseball.domain;

import baseball.constants.SystemConsole;
import baseball.gamescore.Ball;
import baseball.gamescore.Strike;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameResultScore {
    private static final String PATTERN = "[1-2]+";
    private static final String RESTART_INPUT = "플레이어가 숫자 1 또는 2가 아닌 다른 값을 입력하였습니다.";

    public String getGameNumber(List<Integer> computer) {
        Referee referee = new Referee(new Ball(), new Strike(), new CorrectCount());
        Player player = new Player();
        String gameResultNumber;

        List<Integer> playerInput = getPlayerInput(player);
        gameResultNumber = referee.resultJudgment(computer, playerInput);
        return gameResultNumber;
    }

    public List<Integer> getPlayerInput(Player player) {
        String playerNumber = Console.readLine();
        return player.validateAndParse(playerNumber);
    }

    public static String getRestart() {
        SystemConsole.gameWinMessage();
        SystemConsole.gameRestartMessage();
        return playerRestartInput();
    }

    public static String playerRestartInput() {
        String restart = Console.readLine();
        validateCharacters(restart);
        return restart;
    }

    private static void validateCharacters(String restart) {
        if (!(restart.matches(PATTERN))) {
            throw new IllegalArgumentException(RESTART_INPUT);
        }
    }
}
