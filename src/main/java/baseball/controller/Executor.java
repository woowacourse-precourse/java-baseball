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
            Baseball userInputNumber = getUserInputNumber();
            guessResult = compareNumber(computerRandomBaseball, userInputNumber);
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
    public Baseball getUserInputNumber() {
        return inputUserBaseball();
    }
    public Baseball inputUserBaseball() {
        User user = new User();
        return user.getInput();
    }
    public BaseballResult compareNumber(Baseball computerBaseball, Baseball userBaseball) {
        HashMap<String, Integer> check_result = checker.start(computerBaseball, userBaseball);
        return new BaseballResult(check_result);
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
