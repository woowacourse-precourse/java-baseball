package baseball.game;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.GameConstants.DIGITS_OUT_OF_INDEX;

/**
 * Digit의 배열을 감싼 일급 컬렉션입니다
 */
class Digits {
    private static final int START_INDEX = 0;
    private final List<Digit> digitList;

    Digits() {
        this.digitList = new ArrayList<>();
    }

    /**
     * 정적 팩토리 메서드로 빈 Digits 객체를 생성합니다
     *
     * @return Digits객체
     */
    public static Digits create() {
        return new Digits();
    }

    /**
     * Digits에 실제로 포함되어있는 정수의 수를 반환합니다
     *
     * @return digits의 길이
     */
    public int size() {
        return digitList.size();
    }

    /**
     * Digits에 자리별 정수를 반환합니다 index가 잘못되면 IllegalArgumentException
     *
     * @param index 0이면 가장 큰 자리로 size()-1이 가장 작은 의미를 의미합니다
     * @return 실제 그 위치의 정수
     */
    public Digit getDigitInIndex(int index) {
        if (isOutsideOfTheRange(index)) {
            throw new IllegalArgumentException(DIGITS_OUT_OF_INDEX);
        }
        return digitList.get(index);
    }

    private boolean isOutsideOfTheRange(int index) {
        if (index < 0) {
            return true;
        }
        return index >= digitList.size();
    }

    /**
     * Digits에 오른쪽에 한 숫자를 추가하는 메서드
     *
     * @param digit 가장 오른쪽에 추가될 정수 객체
     */
    public void append(Digit digit) {
        digitList.add(digit);
    }

    /**
     * Digits에 왼쪽에 한 숫자를 추가하는 메서드
     *
     * @param digit 가장 왼쪽에 추가될 정수 객체
     */
    public void appendToLeft(Digit digit) {
        digitList.add(START_INDEX, digit);
    }

    /**
     * Digits 에 실제로 주어진 숫자가 포함되어있는지 확인하는 메서드
     *
     * @param digit 포함 여부를 확인할 숫자
     * @return 포함되어있다면 true 아니면 false
     */
    public boolean contains(Digit digit) {
        return digitList.contains(digit);
    }
}
