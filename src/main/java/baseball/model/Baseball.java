package baseball.model;

import java.util.List;
public class Baseball {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private final List<Integer> baseballNumber;

    public Baseball(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public List<Integer> getBaseballNumber() {
        return baseballNumber;
    }

    public int size() {
        return baseballNumber.size();
    }
    public boolean hasNumber(int index, int number) {
        if(baseballNumber.get(index) == number) {
            return true;
        }
        return false;
    }
    public int getNumber(int index) {
        return baseballNumber.get(index);
    }
}
