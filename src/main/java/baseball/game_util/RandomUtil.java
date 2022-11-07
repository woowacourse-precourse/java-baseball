package baseball.game_util;

import static baseball.common.Constants.END_NUMBER_RANGE;
import static baseball.common.Constants.MAX_NUMBER_COUNT;
import static baseball.common.Constants.START_NUMBER_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public static List<Integer> createRandomComputerNumbers() {
        List<Integer> computerNumberList = new ArrayList<>(MAX_NUMBER_COUNT);

        while(computerNumberList.size() < MAX_NUMBER_COUNT) {
            int randomNumber = getRandomNumber();
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER_RANGE, END_NUMBER_RANGE);
    }

}
