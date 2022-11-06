package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameInitProcessorImpl implements GameInitProcessor {

    @Override
    public List<Integer> randomNumber(Integer size) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
