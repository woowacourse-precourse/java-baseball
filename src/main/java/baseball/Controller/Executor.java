package baseball.Controller;

import baseball.model.Baseball;
import baseball.view.Printer;
import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Executor {
    private static Scanner scanner = new Scanner(System.in);
    private static Computer computer;
    private static Checker checker = new Checker();
    public static void startGame(){
        Baseball computerRandomBaseball = new Computer().createRandomBaseball();
        Printer.start();
        guessNumber(computerRandomBaseball);

    }
    public static void guessNumber(Baseball computerRandomBaseBall){
        Baseball userBaseball = new User().getInput();
        Map<String, Integer> check_result = checker.start(computerRandomBaseBall, userBaseball);

    }






}
