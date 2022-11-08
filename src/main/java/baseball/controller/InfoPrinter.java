package baseball.controller;

import java.util.List;

public class InfoPrinter {
    private InfoPrinter() {
    }

    public static void printStartInfo() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputInfo() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printStrikesAndBalls(List<Integer> strikesAndBalls) {
        int strikes = strikesAndBalls.get(0);
        int balls = strikesAndBalls.get(1);
        String result = "";

        if (balls != 0) {
            result += String.format("%d볼 ", balls);
        }
        if (strikes != 0) {
            result += String.format("%d스트라이크", strikes);
        }
        if (result.length() == 0) {
            System.out.println("낫싱");
        }
        System.out.println(result.trim());
    }

    public static void printExitInfo() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printFinishInfo() {
        System.out.println("게임 종료");
    }
}
