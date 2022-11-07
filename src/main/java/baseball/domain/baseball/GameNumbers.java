package baseball.domain.baseball;

import java.util.List;

public class GameNumbers {
    private final List<Integer> numberList;

    public GameNumbers(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public boolean isContains(Integer number) {
        return numberList.contains(number);
    }

    public int getIndex(int number) {
        return numberList.indexOf(number);
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
