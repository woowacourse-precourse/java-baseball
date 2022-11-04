package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public int getStrikeCount(List<Integer> inputs, List<Integer> answer) {
        int count = 0;
        for (int i = 0; i < inputs.size(); i++) {
            if (isStrike(inputs, answer, i)) {
                count++;
            }
        }
        return count;
    }

    public int getBallCount(List<Integer> inputs, List<Integer> answer) {
        int count = 0;
        for (int i = 0; i < inputs.size(); i++) {
            if (answer.contains(inputs.get(i))) {
                count++;
            }
            if (isStrike(inputs, answer, i)) {
                count--;
            }
        }
        return count;
    }

    private void getNothing(List<Integer> inputs, List<Integer> answer) {
        if (!answer.removeAll(inputs)) {
            System.out.println("nothing");
        }
    }

    private boolean isStrike(List<Integer> inputs, List<Integer> answer, int index) {
        return inputs.get(index) == answer.get(index);
    }

}
