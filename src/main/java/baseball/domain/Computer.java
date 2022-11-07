package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int COUNT_VALUE = 3;
    private int[] answer;

    Computer() {
        answer = new int[COUNT_VALUE];
    }

    public int[] getAnswer() {
        return answer;
    }

    public void createRandomNumber(){
        Set<Integer> randomNumberSet = new HashSet<>();
        while (randomNumberSet.size() != COUNT_VALUE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            randomNumberSet.add(randomNumber);
        }
        List<Integer> randomNumberList = new ArrayList<>(randomNumberSet);
        convertListToArray(randomNumberList);

    }

    private void convertListToArray(List<Integer> randomNumberList) {
        for (int i = 0; i < COUNT_VALUE; i++) {
            answer[i] = randomNumberList.get(i);
        }
    }
}
