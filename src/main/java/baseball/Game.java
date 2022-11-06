package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    protected List<Integer> answer = new ArrayList<>();

    public void initAnswer() {
        answer.clear();

        for (int i = 0; i < 3; i++) {
            answer.add(Randoms.pickNumberInRange(1, 9));
        }

        if (isDuplicated(answer)) {
            initAnswer();
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    private boolean isDuplicated(List<Integer> answer) {
        return answer.size() != new HashSet<>(answer).size();
    }
}
