package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;



public class Computer {
    private String number;


    public Computer() {
        try {
            number = this.generateNumber();
        } catch (Exception e) {
            throw e;
        }
    }


    public String getBaseballNumber() {
        return number;
    }

    public String generateNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String number = computer.toString().replaceAll("[^0-9]", "");

        if (!BaseballNumber.isValid(number)) {
            throw new IllegalArgumentException();
        }

        return number;
    }
}
