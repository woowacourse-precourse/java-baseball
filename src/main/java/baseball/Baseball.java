package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private List<Integer> computer;
    private List<Integer> userNumber;

    public void setUserNumber(String number) {
        for (int index = 0; index < number.length(); index++) {
            userNumber.add(Integer.valueOf(number.charAt(index)));
        }
    }

    public Baseball() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
