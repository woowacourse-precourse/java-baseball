package baseball.number.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.number.util.GameNumberRange.*;


public class ComputerNumbers {

    public List<Integer> generateRandomNumbers() {

        List<Integer> computerNumber = new ArrayList<>();
        while(computerNumber.size() < BALL_SIZE.getNumber()) {
            int number = Randoms.pickNumberInRange(RANGE_MIN.getNumber(),RANGE_MAX.getNumber());
            if(!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }
}
