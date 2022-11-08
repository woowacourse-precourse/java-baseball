package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * 여러개의 SingleDigit 으로 이루어진 MultiDigitNumber 수를 담는 일급 컬랙션 클래스
 *
 * @author 호두
 * @version 1.0
 */
public class MultiDigitNumber {

    List<SingleDigit> singleDigitList;

    public MultiDigitNumber(Integer... integers) {
        if (!validateConsistOfThreeDigit(integers)) {
            throw new IllegalArgumentException("MultlDigitNumber는 세자리 수여야 합니다.");
        }

        if (!validateEachSingleDigitIsNotDuplicate(integers)) {
            throw new IllegalArgumentException("MultiDigitNumber의 각 자리수는 중복되어서는 안됩니다.");
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

    public int getStrike(MultiDigitNumber otherMultiDigitNumber) {
        return (int) IntStream.range(0, 3).filter(
                (i) -> singleDigitList.get(i).equals(otherMultiDigitNumber.singleDigitList.get(i)))
            .count();
    }

    public int getBall(MultiDigitNumber otherMultiDigitNumber) {
        List<SingleDigit> otherSingleDigitList = otherMultiDigitNumber.singleDigitList;
        return (int) IntStream.range(0, 3).filter((i) -> {
            int position = otherSingleDigitList.indexOf(singleDigitList.get(i));
            return position != -1 && position != i;
        }).count();
    }

    public boolean equals(Object objectedOtherMultiDigitNumber) {
        MultiDigitNumber otherMultiDigitNumber = (MultiDigitNumber) objectedOtherMultiDigitNumber;
        for (int i = 0; i < 3; i++) {
            if (!otherMultiDigitNumber.singleDigitList.get(i).equals(singleDigitList.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param otherMultiDigitNumber
     * @return 두 MultiDigitNumber 간의 비교 결과를 CompareResult 객체에 담아 반환
     */
    public NumberCompareResult getCompareResult(MultiDigitNumber otherMultiDigitNumber) {
        int strike = getStrike(otherMultiDigitNumber);
        int ball = getBall(otherMultiDigitNumber);

        return new NumberCompareResult(strike, ball);
    }
}
