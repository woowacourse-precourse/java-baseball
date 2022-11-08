package baseball.controller;

import baseball.model.Baseball;
import baseball.view.Printer;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
public class Executor {
    private static Checker checker = new Checker();

    private static  final int RESTART = 1;
    private static final int EXIT = 2;

    private static BaseballResult  result;
    private static boolean flag = true;
    public static void startGame() {
        Baseball computerRandomBaseball = new Computer().createRandomBaseball();
        Printer.gameStart();
        while(flag) {
            Printer.inputNumber();
            result = guessNumber(computerRandomBaseball);
            if(result.isALLCorrect()) {
                String resultString = result.getResult();
                System.out.println(resultString);
                Printer.isALLCorrect();
                askRestart();
            }
        }

    }
    public static BaseballResult guessNumber(Baseball computerRandomBaseball) {
        Baseball userBaseball = new User().getInput();
        HashMap<String, Integer> check_result = checker.start(computerRandomBaseball, userBaseball);
        BaseballResult baseballResult = new BaseballResult(check_result);
        return baseballResult;
    }
    public static void askRestart() {
        Printer.askRestart();
        String s = Console.readLine();
        int reStart = Integer.valueOf(s);
        if(reStart == RESTART) {
            startGame();
        }else if(reStart != EXIT) {
            askRestart();
        }else {
            flag = false;
        }
    }
}
