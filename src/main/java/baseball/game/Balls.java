package baseball.game;

import java.util.List;

public class Balls {
    private List<Integer> numberList;

    public Balls(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}