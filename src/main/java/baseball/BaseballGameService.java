package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {
    private List<Integer> answer;

    public void setGame() {
        this.answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public Hint guess(List<Integer> input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < input.size(); i++) {
            Integer target = input.get(i);
            if (target.equals(answer.get(i))) {
                strike++;
            } else if (answer.contains(target)) {
                ball++;
            }
        }
        return new Hint(strike, ball);
    }
}
