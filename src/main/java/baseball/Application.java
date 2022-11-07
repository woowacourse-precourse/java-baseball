package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    private static void playGame() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            break;
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (Console.readLine().equals("2"))
                break;
        }
    }
}