package baseball;


import static baseball.Constant.GAME_END;
import static baseball.Constant.STRIKE;
import static baseball.Constant.VICTORY;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static Print print;


    static AppConfig baseball = new AppConfig();


    public Game(Print print) {

        this.print = print;
    }

    // 게임 반복 기능
    public static String playGame() {

        Print result = baseball.printResult();
        System.out.println(result);

        if (STRIKE.equals(result)) {
            victory();
            rebootGame();
        }

        Print resultAgain;
        do {
            resultAgain = recursion();

        } while (!STRIKE.equals(resultAgain));

        return GAME_END;

    }

    private static Print recursion() {
        Print resultAgain;
        Input.inputUserNumber(Console.readLine());
        Hint.loopHint(Input.inputUserNumber(Console.readLine()), Player.createComputerNumber());

        resultAgain = baseball.printResult();
        System.out.println(resultAgain);
        return resultAgain;
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

    public static String end() {

        System.out.println(GAME_END);

        return Constant.GAME_END;
    }
}
