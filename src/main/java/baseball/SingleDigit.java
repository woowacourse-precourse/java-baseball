package baseball;

/**
 * 한자리 수(singleDigit)를 담는 일급컬랙션 클래스
 *
 * @author 호두
 * @version 1.0
 */

public class SingleDigit {

    private int singleDigit;

    public SingleDigit(int singleDigit) throws IllegalArgumentException {
        if (!validateDigitInRange(singleDigit)) {
            throw new IllegalArgumentException("각 자리의 숫자는 [1-9] 사이의 값을 가져야 합니다.");
        }
        this.singleDigit = singleDigit;
    }

    @Override
    public boolean equals(Object objectedOtherNumber) {
        SingleDigit otherNumber = (SingleDigit) objectedOtherNumber;
        return this.singleDigit == otherNumber.singleDigit;
    }

    /**
     * @param singleDigit
     * @return [1, 9] 사이의 값인지 여부 반환
     */
    private boolean validateDigitInRange(int singleDigit) {
        return (1 <= singleDigit && singleDigit <= 9);
    }
}
