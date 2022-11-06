package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

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

    public static List<SingleDigit> convertMultiDigitNumberIntoSingleDigitList(int muldiDigitNumber){
        List<SingleDigit> multiDigitNumber = new ArrayList<>();
        while(muldiDigitNumber != 0){
            multiDigitNumber.add(new SingleDigit(muldiDigitNumber % 10));
            muldiDigitNumber /= 10;
        }
        Collections.reverse(multiDigitNumber);
        return multiDigitNumber;
    }

    private int getPositionOfSingleDigitSatisfyingCondition(Predicate<SingleDigit> singleDigitPredicate){
        return singleDigitList.indexOf(singleDigitList.stream()
            .filter(singleDigitPredicate).findFirst());
    }
    private int getStrike(MultiDigitNumber otherMultiDigitNumber){
        return (int) IntStream.range(0, otherMultiDigitNumber.singleDigitList.size())
            .filter((i) -> i == getPositionOfSingleDigitSatisfyingCondition(Predicate.isEqual(otherMultiDigitNumber.singleDigitList.get(i)))).count();
    }
    private int getBall(MultiDigitNumber otherMultiDigitNumber){
        return (int) IntStream.range(0, otherMultiDigitNumber.singleDigitList.size())
            .filter((i) -> {
                int position = getPositionOfSingleDigitSatisfyingCondition(Predicate.isEqual(otherMultiDigitNumber.singleDigitList.get(i)));
                return (position != -1 && position != i);
            }).count();
    }

}
