package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public List<Integer> getRandomNumberList() {
        List<Integer> list = new ArrayList<>();

        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }

    private Boolean isStringLengthThree(String string) {
        return string.length() == 3;
    }

    private Boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
