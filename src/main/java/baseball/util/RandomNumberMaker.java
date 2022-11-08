package baseball.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberMaker {

    public static int generateRandomNumber() {
        List<Integer> curComputerNumberList = new ArrayList<>();
        while (curComputerNumberList.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!curComputerNumberList.contains(randomNumber)) {
                curComputerNumberList.add(randomNumber);
            }
        }
        return Integer.parseInt(curComputerNumberList.toString().replaceAll("[^1-9]", ""));
    }
}
