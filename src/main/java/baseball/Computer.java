package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int RAND_NUM_MAX = 3;
    public List<Integer> createRandomNumber() {
        List<Integer> answer = new ArrayList<>();

        while(answer.size() < RAND_NUM_MAX) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }
}
