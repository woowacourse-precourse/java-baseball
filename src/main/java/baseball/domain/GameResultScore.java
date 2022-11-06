package baseball.domain;

import baseball.constants.SystemConsole;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameResultScore {
    private static final String PATTERN = "[1-2]+";
    private static final String RESTART_INPUT = "플레이어가 숫자 1 또는 2가 아닌 다른 값을 입력하였습니다.";

    public String getGameNumber(Player player, Referee referee, List<Integer> computer) {
        String gameResultNumber;
        List<Integer> playerInput = getPlayerInput(player);
        gameResultNumber = referee.resultJudgment(computer, playerInput);
        return gameResultNumber;
    }
    public List<Integer> getPlayerInput(Player player) {
        String playerNumber = Console.readLine();
        return player.getInput(playerNumber);
    }

    public static String playerRestartInput() {
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
