package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    List<String> computersNumber = new ArrayList<>();

    public Computer() {
        while (computersNumber.size() < 3) {
            int pickNumber = Randoms.pickNumberInRange(1, 9);
            if (!computersNumber.contains(pickNumber)) {
                computersNumber.add(computersNumber.size(), String.valueOf(pickNumber));
            }
        }
    }
}
