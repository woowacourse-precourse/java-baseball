package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerGameNumbers;

    public void setupGameNumbers() {
        computerGameNumbers = new ArrayList<>();
        while (computerGameNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerGameNumbers.contains(randomNumber)) {
                computerGameNumbers.add(randomNumber);
            }
        }
    }
}
