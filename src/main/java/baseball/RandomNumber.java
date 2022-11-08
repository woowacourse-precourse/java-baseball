package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    public List<String> generate() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(Integer.toString(randomNumber))) {
                computer.add(Integer.toString(randomNumber));
            }
        }
        return computer;
    }
}
