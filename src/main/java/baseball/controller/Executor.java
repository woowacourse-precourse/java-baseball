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
            Baseball userInputNumber = inputUserBaseball();
            guessResult = compareNumber(computerRandomBaseball, userInputNumber);
            if(guessResult.isALLCorrect()) {
                String resultString = guessResult.getResult();
                Printer.printMessage(resultString);
                Printer.isALLCorrect();
                int restartAnswer = askRestart();
                processRestartAnswer(restartAnswer);
            }else {
                String resultString = guessResult.getResult();
                Printer.printMessage(resultString);
            }
        }

    }
    private Baseball createRandomBaseball() {
        return new Computer().createRandomBaseball();
    }
    public Baseball inputUserBaseball() {
        User user = new User();
        return user.getInput();
    }
    public BaseballResult compareNumber(Baseball computerBaseball, Baseball userBaseball) {
        HashMap<String, Integer> check_result = checker.start(computerBaseball, userBaseball);
        return new BaseballResult(check_result);
    }
    public int askRestart() {
        Printer.askRestart();
        int restart = getRestart();
        return restart;
    }
    public void processRestartAnswer(int reStart) {
        if(reStart == RESTART) {
            startGame();
        }else if(reStart != EXIT) {
            flag = false;
        }
    }
    public int getRestart() {
        String s = Console.readLine();
        int reStart = Integer.parseInt(s);
        return reStart;
    }
}
