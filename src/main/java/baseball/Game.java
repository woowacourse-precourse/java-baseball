package baseball;


import static baseball.Constant.GAME_END;
import static baseball.Constant.GAME_OVER;
import static baseball.Constant.GAME_START;
import static baseball.Constant.STRIKE;
import static baseball.Constant.VICTORY;
import static baseball.Input.inputUserNumber;
import static baseball.Player.createComputerNumber;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Game {

    private static Map<Integer, Integer> computerBoot = createComputerNumber();


    // 게임 반복 기능
    public static boolean playGame() {

        String readLine = Console.readLine();
        Map<Integer, Integer> user = inputUserNumber(readLine);
        Hint.loopHint(user, computerBoot);

        String result = Print.printResult();
        System.out.println(result);
        boolean recursion = result == STRIKE;

        while ( !recursion ) {

            readLine = Console.readLine();
            user = inputUserNumber(readLine);
            Hint.loopHint(user, computerBoot);
            result = Print.printResult();
            System.out.println(result);
            recursion = result.equals(STRIKE);
        }
        victory();
        System.out.println(GAME_OVER);

        readLine = Console.readLine();
        chooseReboot(readLine);

        return recursion;
    }

    private static String chooseReboot (String readLine) {
        if (parseInt(readLine) == 1) {
            System.out.println(GAME_START);
            Game.playGame();
        }
        while (parseInt(readLine) == 2) {
            System.out.println(GAME_END);
            break;
        }
        return GAME_END;
    }

    // 게임 종료 기능 - 승리
    private static String victory() {

        System.out.println(VICTORY);

        return VICTORY;

    }

}
