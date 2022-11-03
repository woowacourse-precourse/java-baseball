package baseball.view;

import static baseball.entity.NumberBaseball.GAME_ANSWER_MAX_VALUE;

public class Display {
    public static void printInitMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printEndingMessage() {
        System.out.println(GAME_ANSWER_MAX_VALUE+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printReGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static void printBallMessage(int n) {
        System.out.print(n+"볼 ");
    }

    static void printStrikeMessage(int n) {
        System.out.print(n+"스트라이크");
    }

    static void printNothingMessage() {
        System.out.println("낫싱");
    }
}
