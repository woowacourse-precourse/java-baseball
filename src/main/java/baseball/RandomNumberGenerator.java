package baseball;

import static constant.Rules.END_INCLUSIVE;
import static constant.Rules.NUMBER_LENGTH;
import static constant.Rules.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomDigit = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!computer.contains(randomDigit)) {
                computer.add(randomDigit);
            }
        }
        return computer;
    }
}
