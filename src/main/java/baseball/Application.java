package baseball;

import baseball.constants.ExceptionMessage;
import baseball.constants.SystemMessage;
import baseball.domain.NumberGenerator;
import baseball.domain.Player;
import baseball.domain.Referee;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private static final String RESTART = "1";
    private static final String PATTERN = "[1-2]+";
    private static final String GAME_WIN_CONDITIONS = "3스트라이크";

    public static void main(String[] args) {
        Player player = new Player();
        Referee referee = new Referee();
        NumberGenerator numberGenerator = new NumberGenerator();

        String restartNumber = "1";
        String gameResultNumber = "";
        System.out.println(SystemMessage.INITIAL_MESSAGE);

        while (restartNumber.equals(RESTART)) {
            gameResultNumber = "";
            List<Integer> computer = numberGenerator.createRandomNumbers();

            while (!(gameResultNumber.equals(GAME_WIN_CONDITIONS))) {
                System.out.print(SystemMessage.SETUP_MESSAGE);
                String playerNumber = Console.readLine();
                List<Integer> playerInput = player.getInput(playerNumber);

                gameResultNumber = referee.resultJudgment(computer, playerInput);
                System.out.println(gameResultNumber);
            }
            restartNumber = getReStart();
        }
    }

    private static String getReStart() {
        System.out.println(SystemMessage.GAME_WIN_MESSAGE);
        System.out.println(SystemMessage.GAME_RESTART_MESSAGE);

        String restart = Console.readLine();
        String regularExpression = PATTERN;
        if (!(restart.matches(regularExpression))) {
            throw new IllegalArgumentException(ExceptionMessage.RESTART_INPUT);
        }
        return restart;
    }
}
