package baseball.presentation;

import baseball.domain.Balls;
import baseball.domain.GameReport;
import baseball.infrastructure.message.ConsoleOut;
import baseball.infrastructure.util.ComputerRandomNumberGenerator;
import baseball.infrastructure.util.GamerInputNumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {

    public static void Run() {
        System.out.println(ConsoleOut.GAME_START_MESSAGE);
        Balls computer = Balls.from(ComputerRandomNumberGenerator.generate());

        while (true) {
            System.out.print(ConsoleOut.INPUT_NUMBER_MESSAGE);
            List<Integer> gamerNumbers = GamerInputNumberGenerator.generator(Console.readLine());
            Balls gamer = Balls.from(gamerNumbers);

            GameReport gameReport = computer.ballsMatch(gamer);
            if (gameReport.isThreeStrike()) {
                System.out.println(ConsoleOut.THREE_STRIKE_GAME_FINISH_MESSAGE);
                System.out.println(ConsoleOut.RESTART_GAME_MESSAGE);
                if (gameAgain()) {
                    computer = Balls.from(ComputerRandomNumberGenerator.generate());
                    gameReport.clear();
                    continue;
                } else {
                    break;
                }
            }
            if (gameReport.isNothing()) {
                System.out.println(ConsoleOut.NOTHING);
                gameReport.clear();
                continue;
            }
            gameReport.printCurrentGameCount();
        }
        System.out.println(ConsoleOut.GAME_FINISH);
    }

    private static boolean gameAgain() {
        String answer = Console.readLine();
        if (answer.charAt(0) == '1') {
            return true;
        }
        if (answer.charAt(0) == '2') {
            return false;
        }
        return false;
    }
}
