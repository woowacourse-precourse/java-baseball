package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Playable{
    private List<Integer> answer;

    public Computer() {
        this.answer = new ArrayList<>();
    }

    @Override
    public List<Integer> getAnswer() {
        return answer;
    }

    @Override
    public void inputAnswer() {
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
}
