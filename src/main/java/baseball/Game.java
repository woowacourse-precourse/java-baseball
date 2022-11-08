package baseball;


import static baseball.Application.end;
import static baseball.Constant.GAME_END;
import static baseball.Constant.GAME_OVER;
import static baseball.Constant.STRIKE;
import static baseball.Constant.VICTORY;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static AppConfig baseball = new AppConfig();




    // 게임 반복 기능
    public static String playGame() {
        Player.createComputerNumber();

        do {
            recursionGame();
        }
        while ( !recursionGame() );


        String result = baseball.printResult().toString();

        System.out.println(result);
        victory();

        System.out.println(GAME_OVER);

        return rebootGame();
    }

    private static boolean recursionGame() {

        String readLine = Console.readLine();

        if (Integer.valueOf(readLine).equals(2)) {     end();     }

        Hint.loopHint(Input.inputUserNumber(readLine), Player.createComputerNumber());
        String result = Print.printResult().toString();
        System.out.println(result);
        boolean recursion = result.equals(STRIKE);

        return recursion;
    }

    private static String rebootGame() {

        if (Console.readLine().equals(1)) {
            playGame();
        }
        if (Console.readLine().equals(2)) {
            end();
        }

        return GAME_END;
    }


    // 게임 종료 기능 - 승리
    private static String victory() {

        System.out.println(VICTORY);

        return VICTORY;

    }

}
