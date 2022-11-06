package baseball.Players;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> getRandomNumbersList() {

        List<Integer> res = new ArrayList<>();

        while (res.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!res.contains(randomNumber)) {
                res.add(randomNumber);
            }
        }

        return res;
    }

}
