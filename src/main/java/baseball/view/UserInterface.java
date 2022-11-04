package baseball.view;

import baseball.model.MyAnswer;

import java.util.Scanner;

public class UserInterface {
    public UserInterface() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public int inputNumber() {
        int number;
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요 : ");
        number = scanner.nextInt();
        return number;
    }
}
