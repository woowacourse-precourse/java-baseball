package baseball.domain.baseball;

import baseball.util.NumberGenerator;

import java.util.List;

public class Ball {
    private final List<Integer> numberList;

    public Ball() {
        this.numberList = NumberGenerator.createGameNumbers();
    }

    public boolean isContains(Integer number) {
        return numberList.contains(number);
    }

    public int getIndex(int number) {
        return numberList.indexOf(number);
    }
}
