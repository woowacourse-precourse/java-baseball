package baseball.players;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNumbers = new ArrayList<>();

    public Computer() {
        while (computerNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);

            if (!computerNumbers.contains(number))
                computerNumbers.add(number);
        }
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
