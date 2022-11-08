package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BallNumber {
    List<Integer> numberList;

    private BallNumber(List<Integer> numberList) {
        this.numberList = numberList;
    }

    static public BallNumber fromIntegerList(List<Integer> ballNumberList) {
        return new BallNumber(ballNumberList);
    }

    static public BallNumber fromString(String ballNumberString) {
        List<Integer> numberList = ballNumberString.chars().map(charNumber -> charNumber - '0').boxed()
                .collect(Collectors.toList());
        return new BallNumber(numberList);
    }

    public Integer get(int i) {
        return numberList.get(i);
    }

    public int indexOf(Integer number) {
        return numberList.indexOf(number);
    }
}
