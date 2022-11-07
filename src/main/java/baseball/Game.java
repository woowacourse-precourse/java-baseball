package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    SystemMessage systemMessage = new SystemMessage();

    void start() {
        System.out.println(systemMessage.START_GAME_MESSAGE);
        final List<Integer> computerNumbers = setThreeLengthNumberWithoutDuplication();
    }

    List<Integer> setThreeLengthNumberWithoutDuplication() {
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
