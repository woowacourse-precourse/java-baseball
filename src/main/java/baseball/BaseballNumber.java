package baseball;

import java.util.HashSet;
import java.util.List;

import static baseball.Constant.NUMBER_CNT;

public class BaseballNumber {
    private List<Integer> baseballNumber;

    public BaseballNumber(List<Integer> numbers) {
        validate(numbers);
        this.baseballNumber = numbers;
    }

    public void validate(List<Integer> numbers) {
        if(numbers.size() != NUMBER_CNT) {
            throw new IllegalArgumentException("입력값의 크기는 3개여야 합니다");
        }
        HashSet<Integer> resultDuplicateRemoved = new HashSet<>(numbers);
        if(!(resultDuplicateRemoved.size() == NUMBER_CNT)) {
            throw new IllegalArgumentException("값이 중복되서는 안됩니다");
        }
        Integer resultRangeValidated = (int) numbers.stream().filter(number -> 1 <= number && number <= 9).count();
        if (resultRangeValidated != NUMBER_CNT) {
            throw new IllegalArgumentException("1이상 9이하의 숫자만 들어갈 수 있습니다");
        }
    }

    @Override
    public String toString() {
        return "baseballNumber=" + baseballNumber.get(0) + baseballNumber.get(1) + baseballNumber.get(2);
    }

    public Result match(BaseballNumber answer) {
        System.out.println(answer);
        System.out.println(baseballNumber);
        Integer strikeCnt = 0;
        Integer ballCnt = 0;
        
        for (int i = 0; i < NUMBER_CNT; i++) {
            //입력자리수와 answer의 자리수가 같다면 -> strike
            if (answer.isStrike(baseballNumber.get(i), i)) {
                strikeCnt += 1;
                continue;
            }
            // ball
            if (answer.isBall(baseballNumber.get(i), i)) {
                ballCnt += 1;
                continue;
            }
        }
        return new Result(strikeCnt, ballCnt);
    }

    private boolean isBall(Integer digitNumber, Integer digitIdx) {
        if (isStrike(digitNumber, digitIdx)) {
            return false;
        }
        return baseballNumber.contains(digitNumber);
    }

    private boolean isStrike(Integer digitNumber, Integer digitIdx) {
        return baseballNumber.get(digitIdx) == digitNumber;
    }
}
