package baseball.util.io;

import baseball.domain.Baseball;

public class BaseballOutput {

    public static void printInit() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResult(final Baseball baseball) {
        System.out.println(baseball.toString());
    }

    public static void printSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
