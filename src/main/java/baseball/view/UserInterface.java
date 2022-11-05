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
    public int checkGameRestart() {
        int number;
        Scanner scanner = new Scanner(System.in);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        number = scanner.nextInt();

        return number;
    }
    public void printResult(int strikeCount, int ballCount) {
        if(strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if(strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        }
        if(strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }
}
