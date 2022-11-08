package baseball;

import java.util.Map;

public class PrintLine {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void putUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void putRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printResult(Map<String, Integer> scoreTable) {
        if (scoreTable.get("스트라이크") == 0 && scoreTable.get("볼") == 0) {
            System.out.print("낫싱");
        }
        if (scoreTable.get("볼") != 0) {
            System.out.print(scoreTable.get("볼") + "볼 ");
        }
        if (scoreTable.get("스트라이크") != 0) {
            System.out.print(scoreTable.get("스트라이크") + "스트라이크");
        }
        System.out.println();

    }
}
