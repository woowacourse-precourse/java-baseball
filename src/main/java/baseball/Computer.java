package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final Integer MIN = 1;
    private static final Integer MAX = 9;

    public String getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        String computerNumber = "";

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int item : computer) {
            String numberStr = Integer.toString(item);
            computerNumber += numberStr; // 'abc'
        }
        return computerNumber;
    }


}
