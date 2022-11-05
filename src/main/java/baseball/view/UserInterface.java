package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {
    public UserInterface() {

    }
    public int inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        return Integer.parseInt(number);
    }
    public int checkGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();

        return Integer.parseInt(number);
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
