package baseball.resources;

import static baseball.resources.GameConfig.SIZE;

public enum Sentence {
    START("숫자 야구 게임을 시작합니다."),
    ASK_INPUT("숫자를 입력해주세요 : "),
    EXCEPTION("서로 다른 " + SIZE + "개의 자연수를 입력하세요");

    private final String message;

    Sentence(String message) {
        this.message = message;
    }

    public static void print(Sentence sentence) {
        System.out.println(sentence.message);
    }

    public static void throwException(Sentence sentence) {
        throw new IllegalArgumentException(sentence.message);
    }
}
