package baseball.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

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
