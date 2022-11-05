package baseball.number.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    public List<Integer> generateRandomNumbers() {

        List<Integer> computerNumber = new ArrayList<>();
        while(computerNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1,9);
            if(!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }
}
