package baseball.game;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.GameConstants.INPUT_DUPLICATE;
import static baseball.config.GameConstants.INPUT_OUT_OF_RANGE;
import static baseball.config.GameConstants.MAX_INPUT_INCLUSIVE;
import static baseball.config.GameConstants.MIN_INPUT_INCLUSIVE;

/**
 * 사용자 입력이 유효한 지 검증하는 클래스
 */
final class PlayerInput extends Digits {
    private PlayerInput(int value) {
        if (!isInputValidInRange(value)) {
            throw new IllegalArgumentException(INPUT_OUT_OF_RANGE);
        }
        splitDigit(value).forEach(this::appendIfNotExist);
    }

    /**
     * 사용자의 입력을 검증하고, 유효하다면 PlayerInput객체를 반환하는 정적 팩토리 메서드
     * 유효하지 않다면 IllegalArgumentException
     *
     * @param value 사용자의 입력을 통해 만들어진 정수
     * @return 조건에 맞는 경우 PlayerInput객체를 반환함
     */
    public static Digits from(int value) {
        return new PlayerInput(value);
    }

    private boolean isInputValidInRange(int value) {
        return MIN_INPUT_INCLUSIVE <= value && value <= MAX_INPUT_INCLUSIVE;
    }

    private List<Digit> splitDigit(int value) {
        List<Digit> result = new ArrayList<>();
        while (value > 0) {
            result.add(0, Digit.from(value % 10));
            value /= 10;
        }
        return result;
    }

    private void appendIfNotExist(Digit digit) {
        if (contains(digit)) {
            throw new IllegalArgumentException(INPUT_DUPLICATE);
        }
        append(digit);
    }
}
