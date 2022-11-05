package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {

    private Integer[] answer;
    private static final int MAX_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public Computer() {
        answer = new Integer[MAX_LENGTH];
    }

    public void generateValue() {
        Set<Integer> value = new HashSet<>();
        while (value.size() < MAX_LENGTH) {
            value.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        setToArray(value);
    }

    private void setToArray(Set<Integer> value) {
        int index = 0;
        for (Integer number : value) {
            answer[index] = number;
            index++;
        }
    }

    public boolean isAnswer(Integer[] value) {
        return true;
    }
}