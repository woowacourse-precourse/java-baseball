package baseball.number.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    public List<Integer> generateRandomNumbers() {

        List<Integer> computerNumber = new ArrayList<>();
        for(int i= 0; i<3; i++) {
            int number = Randoms.pickNumberInRange(1,9);
            computerNumber.add(number);
        }

        return computerNumber;
    }
}
