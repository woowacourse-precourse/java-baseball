package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.GameConstant.BALL_LEN;
import static baseball.constant.GameConstant.BALL_START;
import static baseball.constant.GameConstant.BALL_END;


public class ComputerNumber {

    public static List<Integer> createComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < BALL_LEN) {
            int randomNumber = Randoms.pickNumberInRange(BALL_START, BALL_END);
            if (!computerNumbers.contains(randomNumber)) computerNumbers.add(randomNumber);
        }
        return computerNumbers;
    }
}
