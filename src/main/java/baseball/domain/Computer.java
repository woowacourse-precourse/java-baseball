package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> ballCounts = new ArrayList<>();
    private static Computer instance = new Computer();

    private Computer() {
    }

    public static Computer getInstance() {
        return instance;
    }

}
