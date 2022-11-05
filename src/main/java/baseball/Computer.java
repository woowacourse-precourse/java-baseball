package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    List<Integer> computer = new ArrayList<>();

    public Computer() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandomNumber() {
        return computer;
    }

    public List<Integer> calcHint(String playerInput, String computerInput) {
        int ballOfHint = 0;
        int strikeOfHint = 0;

        for (int i = 0; i < 3; i++) {
            if (computerInput.charAt(i) == playerInput.charAt(i)) {
                strikeOfHint += 1;
            } else if (computerInput.contains(Character.toString(playerInput.charAt(i)))) {
                ballOfHint += 1;
            }
        }

        return Arrays.asList(ballOfHint, strikeOfHint);
    }
}
