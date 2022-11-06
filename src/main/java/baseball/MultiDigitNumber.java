package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/**
 * 여러개의 SingleDigit 으로 이루어진 MultiDigitNumber 수를 담는 일급 컬랙션 클래스
 *
 * @author 호두
 * @version 1.0
 */
public class MultiDigitNumber {
    List<SingleDigit> singleDigitList;

    public MultiDigitNumber(int multiDigitNumber){
        if(!validateConsistOfThreeDigit(multiDigitNumber)){
            throw new IllegalArgumentException("MultlDigitNumber는 세자리 수여야 합니다.");
        }
        this.singleDigitList = convertMultiDigitNumberIntoSingleDigitList(multiDigitNumber);

        if(!validateEachSingleDigitIsNotDuplicate(singleDigitList)) {
            throw new IllegalArgumentException("MultiDigitNumber의 각 자리수는 중복되어서는 안됩니다.");
        }
    }

    public static boolean validateEachSingleDigitIsNotDuplicate(List<SingleDigit> singleDigitList){
        return singleDigitList.stream()
            .filter((singleDigit) ->
                (singleDigitList.stream().filter((otherSingleDigit)
                    -> singleDigit.equals(otherSingleDigit)).count() > 1))
            .count() == 0;
    }
    public static boolean validateConsistOfThreeDigit(int multiDigitNumber){
        return String.valueOf(multiDigitNumber).length() == 3;
    }

    public static List<SingleDigit> convertMultiDigitNumberIntoSingleDigitList(int multiDigitNumber){
        List<SingleDigit> singleDigitList = new ArrayList<>();
        while(multiDigitNumber != 0){
            singleDigitList.add(new SingleDigit(multiDigitNumber % 10));
            multiDigitNumber /= 10;
        }
        Collections.reverse(singleDigitList);
        return singleDigitList;
    }

    public int getStrike(MultiDigitNumber otherMultiDigitNumber){
        return (int) IntStream.range(0, 3)
            .filter((i) -> singleDigitList.get(i).equals(otherMultiDigitNumber.singleDigitList.get(i))).count();
    }
    public int getBall(MultiDigitNumber otherMultiDigitNumber){
        List<SingleDigit> otherSingleDigitList = otherMultiDigitNumber.singleDigitList;
        return (int) IntStream.range(0, 3)
            .filter((i) -> {
                int position = otherSingleDigitList.indexOf(singleDigitList.get(i));
                return position != -1 && position != i;
            }).count();
    }

    /**
     * @param otherMultiDigitNumber
     * @return 두 MultiDigitNumber 간의 비교 결과를 CompareResult 객체에 담아 반환
     */
    public NumberCompareResult getCompareResult(MultiDigitNumber otherMultiDigitNumber){
        int strike = getStrike(otherMultiDigitNumber);
        int ball = getBall(otherMultiDigitNumber);

        return new NumberCompareResult(strike,ball);
    }
}
