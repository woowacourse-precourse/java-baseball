package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rule {
    private List<Integer> answer;
    private List<String> hint;

    public Rule() {
    }

    public void generateAnswer() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public String getHint() {
        return String.join(" ", hint);
    }

    public void getTotalCount(List<Integer> inputs) {
        hint = new ArrayList<>();
        getBallCount(inputs);
        getStrikeCount(inputs);
        getNothing(inputs);
    }

    private void getStrikeCount(List<Integer> inputs) {
        int count = 0;
        for (int i = 0; i < inputs.size(); i++) {
            if (isStrike(inputs, i)) {
                count++;
            }
        }
        if (count != 0) {
            hint.add(count + "스트라이크");
        }
    }

    private void getBallCount(List<Integer> inputs) {
        int count = 0;
        hint = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            if (answer.contains(inputs.get(i))) {
                count++;
            }
            if (isStrike(inputs, i)) {
                count--;
            }
        }
        if (count != 0) {
            hint.add(count + "볼");
        }
    }

    private void getNothing(List<Integer> inputs) {
        if (hint.isEmpty()) {
            hint.add("낫싱");
        }
    }

    private boolean isStrike(List<Integer> inputs, int index) {
        return inputs.get(index) == answer.get(index);
    }

    public boolean is3Strike(List<Integer> inputs) {
        return Arrays.equals(inputs.toArray(), answer.toArray());
    }
}
