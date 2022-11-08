package baseball.domain.computer;

import baseball.util.BallCount;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Computer {

    private final Map<Integer, Integer> answer = new HashMap<>();

    public void initialize(){
        while (answer.size() < 3) {
            addNumber();
        }
    }

    public void addNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answer.containsKey(randomNumber)) {
            answer.put(randomNumber,answer.size());
        }
    }
}
