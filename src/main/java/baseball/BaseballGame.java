package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다";

    private List<Integer> computer;

    public BaseballGame() {
    }

    public void run() {
        System.out.println(GAME_START);

        makeRandomNumber();
    }

    private void makeRandomNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
