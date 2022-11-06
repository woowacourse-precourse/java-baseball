package baseball.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.next();
        return input;
    }

    public String playerInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input=scanner.next();
        return input;
    }
}
