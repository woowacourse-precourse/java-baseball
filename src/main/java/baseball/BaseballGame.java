package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballGame {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    List<Integer> randomList = new ArrayList<>();

    public BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        createNumber();
    }

    private void createNumber() {
        while (randomList.size() < 3) {
            int randomNumber = pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            addRandomNumber(randomNumber);
        }
        System.out.println(randomList);
    }

    private void addRandomNumber(int randomNumber) {
        if (!randomList.contains(randomNumber)) {
            randomList.add(randomNumber);
        }
    }

}
