package features;


import static extract.Constant.GAME_END;
import static extract.Constant.GAME_OVER;
import static extract.Constant.STRIKE;
import static extract.Constant.VICTORY;
import static features.Print.printResult;

import camp.nextstep.edu.missionutils.Console;
import extract.Constant;

public class Game {

    public static Print print;
    private static boolean recursion = STRIKE.equals(printResult());


    public Game(Print print) {

        this.print = print;
    }

    // 게임 반복 기능
    public static String playGame() {



        if ( recursion ){
            victory();
            System.out.println(GAME_OVER);
            Game.rebootGame();
        }

        do {
            Console.readLine();
            System.out.println(printResult());
        } while ( !recursion );

        return GAME_END;

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
