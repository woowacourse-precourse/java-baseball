package baseball.entity;

import static utils.Constant.DIGIT_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Computer {
    private List<Integer> answer;

    private void createAnswer(){
        answer = new ArrayList<>();
        while (answer.size() < DIGIT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
}
