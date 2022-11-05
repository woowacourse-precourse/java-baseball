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
        int firstElementOfHint = 0;
        int secondElementOfHint = 0;

        for (int i = 0; i < 3; i++) {
            if (computerInput.charAt(i) == playerInput.charAt(i)) {
                firstElementOfHint += 1;
            }
            if (computerInput.contains(Character.toString(playerInput.charAt(i)))) {
                secondElementOfHint += 1;
            }
        }

        return Arrays.asList(firstElementOfHint, secondElementOfHint);
    }
}
