package baseball;


import static baseball.Application.end;
import static baseball.Constant.GAME_OVER;
import static baseball.Constant.GAME_START;
import static baseball.Constant.STRIKE;
import static baseball.Constant.VICTORY;
import static baseball.Player.createComputerNumber;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Game {

    public static Map<Integer, Integer> computer = createComputerNumber();




    // 게임 반복 기능
    public static void playGame() {
        createComputerNumber();
        do {
            recursionGame();
        }
        while ( !recursionGame() );

        String result = Print.printResult().toString();

        System.out.println(result);

        if (recursionGame()){
            victory();

            System.out.println(GAME_OVER);

        }
        return;
    }

    public static boolean recursionGame() {

        String readLine = Console.readLine();

        if (parseInt(readLine) == 1) {
            createComputerNumber();
            Game.playGame();
        }
        if (parseInt(readLine) == 2) { end(); }

        Map<Integer, Integer> user = Input.inputUserNumber(readLine);
        Hint.loopHint( user,  computer);

        String result = Print.printResult();
        System.out.println(result);
        boolean recursion = result.equals(STRIKE);

        return recursion;
    }


    private void rebootGame() {

        if (Integer.valueOf(Console.readLine()).equals(1)) {
            System.out.println(GAME_START);
            playGame();
        }
        if (Integer.valueOf(Console.readLine()).equals(2)) {
            end();
        }

        return;
    }


    // 게임 종료 기능 - 승리
    private static String victory() {

        System.out.println(VICTORY);

        return VICTORY;

    }

}
