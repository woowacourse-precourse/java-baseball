package baseball.view;

import java.util.Scanner;

import static baseball.constValue.Constants.InputMessage.*;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public void printGameStart(){
        System.out.println(START_MESSAGE);
    }

    public String restart(){
        System.out.println(RESTART_MESSAGE);
        String input = scanner.next();
        return input;
    }

    public String playerInput(){
        System.out.print(INPUT_MESSAGE);
        String input=scanner.next();
        return input;
    }
}
