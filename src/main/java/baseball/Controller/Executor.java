package baseball.Controller;

import baseball.model.Baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Executor {
    private static Scanner scanner = new Scanner(System.in);
    private static Computer computer;

    public static void startGame(){
        Baseball randomBaseball = new Computer().createRandomBaseball();
    }


}
