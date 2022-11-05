package baseball;

/**
 * 여러개의 SingleDigit 으로 이루어진 MultiDigitNumber 수를 담는 일급 컬랙션 인터페이스
 *
 * @author 호두
 * @version 1.0
 */
public interface MultiDigitNumberForGame {

    /**
     * @param number 입력으로 주어지는 MultiDigitNumber
     * @return 주어진 number 가 유효한 경우 true, 그렇지 않으면 false 반환
     */
    boolean validateMultiDigitNumber(int number);

    /**
     * @param otherNumberForGame
     * @return 두 MultiDigitNumber 간의 비교 결과를 CompareResult 객체에 담아 반환
     */
    CompareResult getCompareResult(MultiDigitNumberForGame otherNumberForGame);
}
