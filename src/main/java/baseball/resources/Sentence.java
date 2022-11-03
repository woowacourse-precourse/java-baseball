package baseball.resources;

import static baseball.resources.GameConfig.*;

public enum Sentence {
    START("숫자 야구 게임을 시작합니다."),
    ASK_INPUT("숫자를 입력해주세요 : "),
    ASK_RESTART(SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + FINISH + "를 입력하세요."),

    BALL_STRIKE("%d볼 %d스트라이크\n"),
    STRIKE("%d스트라이크\n"),
    BALL("%d볼\n"),
    NOTHING("낫싱"),

    EXCEPTION("서로 다른 " + SIZE + "개의 자연수를 입력하세요");

    private final String message;

    Sentence(String message) {
        this.message = message;
    }

    public static void print(Sentence sentence) {
        System.out.print(sentence.message);
    }

    public static void println(Sentence sentence) {
        System.out.println(sentence.message);
    }

    public static void printf(Sentence sentence, int count) {
        System.out.printf(sentence.message, count);
    }

    public static void printf(Sentence sentence, int ball, int strike) {
        System.out.printf(sentence.message, ball, strike);
    }

    public static void throwException(Sentence sentence) {
        throw new IllegalArgumentException(sentence.message);
    }
}
