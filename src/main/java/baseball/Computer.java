package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    List<String> computersDigit = new ArrayList<>();

    public Computer() {
        while (computersDigit.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!computersDigit.contains(pickNumber)) {
                computersDigit.add(computersDigit.size(), String.valueOf(pickNumber));
            }
        }
    }
}
