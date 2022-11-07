package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Catcher {
    private List<Integer> catcherNumbers = new ArrayList<>();

    Catcher() {
        setCatcherNumbers();
    }

    public void setCatcherNumbers() {
        while (catcherNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!catcherNumbers.contains(randomNumber)) {
                catcherNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getCatcherNumbers() {
        return catcherNumbers;
    }

    public void forTest_setter() {
        catcherNumbers.clear();
        catcherNumbers.add(7);
        catcherNumbers.add(1);
        catcherNumbers.add(3);
    }
}
