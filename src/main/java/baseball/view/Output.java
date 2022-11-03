package baseball.view;

import baseball.domain.Hint;

public class Output {

    private static StringBuilder stringBuilder;

    public static void printStartGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printHint(Hint hint) {
        stringBuilder = new StringBuilder();
     int strike=hint.getStrike();
     int ball = hint.getBall();
        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫씽");
        } else if (strike != 0 && ball == 0) {
            stringBuilder.append(strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            stringBuilder.append(ball + "볼");
        } else if (strike != 0 && ball != 0) {
            stringBuilder.append(ball + "볼").append(strike + "스트라이크");
        }
        System.out.println(stringBuilder);
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
