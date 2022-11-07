package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        onGame();
    }

    static void onGame() {
        List<Integer> computer = createComputerValue();

    }

    static List<Integer> createComputerValue() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
