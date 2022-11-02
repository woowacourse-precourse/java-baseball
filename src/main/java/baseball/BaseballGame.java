package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public final static int NUMBER_COUNT_TO_CREATED = 3;

    private List<Integer> computerNumbers = new ArrayList<>();

    public void start() {
        System.out.println(GAME_START_MESSAGE);
        createComputerNumbers();
    }

    private void createComputerNumbers() {
        while (computerNumbers.size() < NUMBER_COUNT_TO_CREATED) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
