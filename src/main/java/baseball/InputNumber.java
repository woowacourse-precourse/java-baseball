package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    String userBaseBallNumber;
    List<Integer> computerBaseBallNumber = new ArrayList<>();


    public void inputComputerBaseballNumber() {
        while (computerBaseBallNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerBaseBallNumber.contains(randomNumber)) {
                computerBaseBallNumber.add(randomNumber);
            }
        }
    }

    public void inputUserBaseballNumber() {
        userBaseBallNumber = Console.readLine();
    }


}
