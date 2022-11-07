package baseball.util;

import baseball.status.NumberStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
    public static List<String> getComputerNumberList() {
        List<String> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < NumberStatus.MAX_NUMBER.getNumber()) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(NumberStatus.ANSWER_MIN_NUMBER.getNumber(),
                    NumberStatus.ANSWER_MAX_NUMBER.getNumber()));
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }
}
