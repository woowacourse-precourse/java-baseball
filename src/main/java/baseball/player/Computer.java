package baseball.player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer implements Playable{
    private List<Integer> answer;

    @Override
    public List<Integer> getNumber() {
        return answer;
    }

    @Override
    public void setNumber() {
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
}
