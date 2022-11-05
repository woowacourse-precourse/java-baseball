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

    public List<Integer> calcHint(String hint) {
        int firstElementOfHint = 0;
        int secondElementOfHint = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.toString().charAt(i) == hint.charAt(i)) {
                firstElementOfHint += 1;
            }
            if (computer.toString().contains(Character.toString(hint.charAt(i)))) {
                secondElementOfHint += 1;
            }
        }

        return Arrays.asList(firstElementOfHint, secondElementOfHint);
    }
}
