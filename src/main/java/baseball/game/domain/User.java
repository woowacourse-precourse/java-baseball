package baseball.game.domain;

import java.util.List;

public class User {
    private List<Integer> numberList;

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
