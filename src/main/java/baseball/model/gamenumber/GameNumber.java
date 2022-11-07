package baseball.model.gamenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameNumber {
    public static final int NUMBER_DIGITS = 3;

    private List<Integer> numberList = new ArrayList<>(NUMBER_DIGITS);

    public GameNumber() {
    }

    public GameNumber(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public GameNumber(String numberString) {
        numberList = Arrays.stream(numberString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void clear() {
        numberList.clear();
    }
}