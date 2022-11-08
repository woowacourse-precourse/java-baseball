package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberList {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int NUMBER_LENGTH = Application.NUMBER_LENGTH();

    private static List<BaseBallNumber> randomNumberList;

    public RandomNumberList() {
        this.randomNumberList = makeRandomNumberList();
    }

    private List<BaseBallNumber> makeRandomNumberList() {
        List<BaseBallNumber> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < NUMBER_LENGTH) {
            BaseBallNumber randomNumber = new BaseBallNumber(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public List<BaseBallNumber> randomNumberList() {
        return Collections.unmodifiableList(randomNumberList);
    }
}
