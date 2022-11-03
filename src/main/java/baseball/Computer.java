package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;



public class Computer {
    BaseballNumber computerNumber;


    public Computer() {
        computerNumber = new BaseballNumber();

        this.generateNumber();
    }


    public void generateNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String number = computer.toString().replaceAll("[^0-9]", "");

        computerNumber.set(number);
    }
}
