package baseball.controller;

import baseball.model.Baseball;
import baseball.view.Printer;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
public class Executor {

    private static  final int RESTART = 1;
    private static final int EXIT = 2;

    private BaseballResult guessResult;
    private final Checker checker = new Checker();
    private boolean flag = true;
    public void startGame() {
        Baseball computerRandomBaseball = createRandomBaseball();
        Printer.gameStart();
        while(flag) {
            Printer.inputNumber();
            guessResult = guessNumber(computerRandomBaseball);
            if(guessResult.isALLCorrect()) {
                String resultString = guessResult.getResult();
                System.out.println(resultString);
                Printer.isALLCorrect();
                askRestart();
            }
        }

    }

    private Baseball createRandomBaseball() {
        return new Computer().createRandomBaseball();
    }

    public BaseballResult guessNumber(Baseball computerRandomBaseball) {
        Baseball userBaseball = inputUserBaseball();
        HashMap<String, Integer> check_result = checker.start(computerRandomBaseball, userBaseball);
        return new BaseballResult(check_result);
    }
    public Baseball inputUserBaseball() {
        User user = new User();
        Baseball userBaseball = user.getInput();
        return userBaseball;
    }
    public void askRestart() {
        Printer.askRestart();
        String s = Console.readLine();
        int reStart = Integer.parseInt(s);
        if(reStart == RESTART) {
            startGame();
        }else if(reStart != EXIT) {
            askRestart();
        }else {
            flag = false;
        }
    }
}
