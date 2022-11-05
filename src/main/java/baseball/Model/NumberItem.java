package baseball.Model;

import java.util.List;

public class NumberItem {
    private List<Integer> number;

    public NumberItem() {
    }

    public NumberItem(List<Integer> number) {
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }
}
