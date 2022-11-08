package baseball.game;

import java.util.Arrays;

/**
 * 1자리 숫자의 범위를 관리하는 enum입니다
 */
enum Digit {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);
    private final int value;

    Digit(int value) {
        this.value = value;
    }

    /**
     * 정적 팩토리 메서드로 0~9 사이에 해당하는 숫자를 받아서 해당하는 enum을 반환해줍니다
     *
     * @param value 0,1,2,3,4,5,6,7,8,9에 해당하는 정수
     * @return 실제 값을 감싼 Digit의 enum객체
     */
    public static Digit from(int value) {
        return Arrays.stream(Digit.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
