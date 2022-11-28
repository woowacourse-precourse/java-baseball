package baseball.model.number;

import baseball.util.constant.GameNumberConst;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public enum RandomNumberGenerator{
    INSTANCE;
    private static final int MIN_NUMBER_INCLUSIVE = GameNumberConst.MIN_NUMBER;
    private static final int MAX_NUMBER_INCLUSIVE = GameNumberConst.MAX_NUMBER;
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < GameNumberConst.NUMBER_SIZE) {
            numbers = plusDistinctRandomNumber(numbers);
        }
        return numbers;
    }

    private List<Integer> plusDistinctRandomNumber(List<Integer> source) {
        List<Integer> numbers = new ArrayList<>(source);
        int number = Randoms.pickNumberInRange(MIN_NUMBER_INCLUSIVE, MAX_NUMBER_INCLUSIVE);
        if(!numbers.contains(number)) {
            numbers.add(number);
        }
        return numbers;
    }


}
