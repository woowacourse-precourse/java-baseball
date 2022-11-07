package baseball.infrastructure.util;

import baseball.infrastructure.message.ConsoleOut;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumberGenerator {

    public static List<Integer> generate() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < ConsoleOut.BALL_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }

}
