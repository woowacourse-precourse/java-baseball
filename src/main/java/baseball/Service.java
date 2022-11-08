package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {
    private int strike, ball;

    public Service() {}

    public String getComNumInput() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String convertedNum = String.valueOf(randomNumber);
            if (!computer.contains(convertedNum)) {
                computer.add(convertedNum);
            }
        }
        return String.join("", computer);
    }

    public void compareIdxAndIncreaseScore(int comIdx, int userIdx) {
        if (userIdx == comIdx) {
            increaseScore("S");
            return;
        }
        increaseScore("B");
    }

    public void increaseScore(String type) {
        if (type.compareTo("S") == 0) {
            strike++;
            return;
        }
        ball++;
    }
}
