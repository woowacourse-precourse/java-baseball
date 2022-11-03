package baseball.resources;

import java.util.Map;

import static baseball.resources.GameConfig.*;

public enum Sentence {
    START("숫자 야구 게임을 시작합니다."),
    ASK_INPUT("숫자를 입력해주세요 : "),
    BALL_STRIKE("%d볼 %d스트라이크"),
    STRIKE("%d스트라이크"),
    BALL("%d볼"),
    NOTHING("낫싱"),
    EXCEPTION("서로 다른 " + SIZE + "개의 자연수를 입력하세요");

    private final String message;

    Sentence(String message) {
        this.message = message;
    }

    public static void print(Sentence sentence) {
        System.out.println(sentence.message);
    }

    public static void print(Map<String, Integer> result) {
        if (result.containsKey("strike") && result.containsKey("ball")) {
            int strike = result.get("strike");
            int ball = result.get("ball");
            System.out.printf(BALL_STRIKE.message + "%n", strike, ball);
            return;
        }
        if (result.containsKey("strike")) {
            int strike = result.get("strike");
            System.out.printf(STRIKE.message + "%n", strike);
            return;
        }
        if (result.containsKey("ball")) {
            int ball = result.get("ball");
            System.out.printf(BALL.message + "%n", ball);
            return;
        }
        System.out.println(NOTHING.message);
    }

    public static void throwException(Sentence sentence) {
        throw new IllegalArgumentException(sentence.message);
    }
}
