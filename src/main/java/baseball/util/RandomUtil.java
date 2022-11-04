package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public static List<String> getComputerNumberList(){
        List<String> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(String.valueOf(randomNumber));
            }
        }
        return computerNumberList;
    }
}
