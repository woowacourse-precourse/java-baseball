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
    private void validate(List<Integer> baseballNumber) throws  IllegalArgumentException {
        if(!isCorrectState(baseballNumber)) {
            throw new IllegalArgumentException(ZERO + "가 아닌 " + BASEBALL_LENGTH + "자리 수를 입력해주세요");
        }
    }
    public List<Integer> getBaseballNumber() {
        return baseballNumber;
    }
    private boolean isCorrectState(List<Integer> baseballNumber) {
        if(baseballNumber.size() == BASEBALL_LENGTH && !baseballNumber.contains(ZERO)) {
            return true;
        }
        return false;
    }
}
