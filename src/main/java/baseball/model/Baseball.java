package baseball.model;

import java.util.List;

public class Baseball {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    public static final int BASEBALL_LENGTH = 3;
    public static final int ZERO = 0;
    private final List<Integer> baseballNumber;

    public Baseball(List<Integer> baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public List<Integer> getBaseballNumber() {
        return baseballNumber;
    }

    private boolean isCorrectState(List<Integer> baseballNumber){
        if(baseballNumber.size() == BASEBALL_LENGTH && !baseballNumber.contains(ZERO)){
            return true;
        }
        return false;
    }

    public boolean hasNumber(int index, int number){
        if(baseballNumber.get(index) == number){
            return true;
        }
        return false;
    }

    public int getNumber(int index){
        return baseballNumber.get(index);
    }

    public int size(){
        return baseballNumber.size();
    }
}
