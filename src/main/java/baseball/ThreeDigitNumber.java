package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 3개의 SingleDigit 으로 이루어진 ThreeDigitNumber 수를 담는 일급 컬랙션 클래스
 *
 * @author 호두
 * @version 1.0
 */
public class ThreeDigitNumber {

    List<SingleDigit> singleDigitList;

    public ThreeDigitNumber(Integer... integers) throws IllegalArgumentException {
        if (!validateConsistOfThreeDigit(integers)) {
            throw new IllegalArgumentException("ThreeDigitNumber는 세자리 수여야 합니다.");
        }

        if (!validateEachSingleDigitIsNotDuplicate(integers)) {
            throw new IllegalArgumentException("ThreeDigitNumber의 각 자리수는 중복되어서는 안됩니다.");
        }

        singleDigitList = new ArrayList<>();

        for (int i = 0; i < integers.length; i++) {
            singleDigitList.add(new SingleDigit(integers[i]));
        }
    }

    public static boolean validateEachSingleDigitIsNotDuplicate(Integer... integers) {
        Set<Integer> integerSet = new HashSet<>(List.of(integers));
        return integerSet.size() == 3;
    }

    public static boolean validateConsistOfThreeDigit(Integer... integers) {
        return integers.length == 3;
    }

    public int getStrike(ThreeDigitNumber otherThreeDigitNumber) {
        return (int) IntStream.range(0, 3)
                .filter((i) -> singleDigitList.get(i).equals(otherThreeDigitNumber.singleDigitList.get(i))).count();
    }

    public int getBall(ThreeDigitNumber otherThreeDigitNumber) {
        List<SingleDigit> otherSingleDigitList = otherThreeDigitNumber.singleDigitList;
        return (int) IntStream.range(0, 3).filter((i) -> {
            int position = otherSingleDigitList.indexOf(singleDigitList.get(i));
            return position != -1 && position != i;
        }).count();
    }

    public boolean equals(Object objectedOtherThreeDigitNumber) {
        ThreeDigitNumber otherThreeDigitNumber = (ThreeDigitNumber) objectedOtherThreeDigitNumber;
        for (int i = 0; i < 3; i++) {
            if (!otherThreeDigitNumber.singleDigitList.get(i).equals(singleDigitList.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param otherThreeDigitNumber
     * @return 두 threeDigitNumber 간의 비교 결과를 CompareResult 객체에 담아 반환
     */
    public NumberCompareResult getCompareResult(ThreeDigitNumber otherThreeDigitNumber) {
        int strike = getStrike(otherThreeDigitNumber);
        int ball = getBall(otherThreeDigitNumber);

        return new NumberCompareResult(strike, ball);
    }
}
