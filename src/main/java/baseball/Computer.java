package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> myNumberList = new ArrayList<>();

    public void makeRandomNumber() {
        while (myNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!myNumberList.contains(randomNumber)) {
                myNumberList.add(randomNumber);
            }
        }
    }
}
