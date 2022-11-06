package baseball;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;


public class Computer {
    private final int computerNumber;

    public Computer(){
        List<Integer> curComputerNumberList = new ArrayList<>();
        while (curComputerNumberList.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!curComputerNumberList.contains(randomNumber)) {
                curComputerNumberList.add(randomNumber);
            }
        }

        computerNumber = Integer.parseInt(curComputerNumberList.toString().replaceAll("[^1-9]",""));
    }

    public int getComputerNumber() {
        return computerNumber;
    }
}
