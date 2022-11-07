package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.status.NumberStatus.*;

public class RandomUtil {

    public static List<String> getComputerNumberList() {
        List<String> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < MAX_NUMBER.getNumber()) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(ANSWER_MIN_NUMBER.getNumber(), ANSWER_MAX_NUMBER.getNumber()));
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }
}
