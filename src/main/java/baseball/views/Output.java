package baseball.views;

import baseball.utils.ResultRenderer;

public class Output {
    private Output() {
    }

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void result(int strike, int ball) {
        String result = ResultRenderer.getResult(strike, ball);
        System.out.println(result);
    }
}
