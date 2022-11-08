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

    public Integer get(int i) {
        return numberList.get(i);
    }
}
