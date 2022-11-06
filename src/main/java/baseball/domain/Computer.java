package baseball.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static List<Integer> Number;

    public List<Integer> getRandomNumber() {
        return Number;
    }

    public void setRandomNumber() {
        Number = new ArrayList<>();
        while (Number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Number.contains(randomNumber)) {
                Number.add(randomNumber);
            }
        }
    }
}
