package baseball.game;

import java.util.Arrays;

/**
 * 게임 도중에 나올 수 있는 Strike의 범위를 관리하는 enum입니다
 */
enum Strike {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3);
    private final int value;

    Strike(int value) {
        this.value = value;
    }

    /**
     * 정적 팩토리 메서드로 0~3사이에 해당하는 숫자를 받아서 해당하는 enum을 반환해줍니다
     *
     * @param value 0,1,2,3에 해당하는 정수
     * @return 실제 값을 감싼 Strike의 enum객체
     */
    public static Strike from(int value) {
        return Arrays.stream(Strike.values())
                .filter(it -> it.value == value)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
