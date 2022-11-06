package baseball.object;

import java.util.List;

public class StrikeNumber {
    private List<Integer> number;

    public StrikeNumber(List<Integer> number) {
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }

    public Integer numberAt(Integer idx) {
        return number.get(idx);
    }
}
