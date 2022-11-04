package baseball.players;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    List<Integer> computerNumbers = new ArrayList<>();

    public Computer(List<Integer> computerNumbers) {

        int number = Randoms.pickNumberInRange(1, 9);

        while (computerNumbers.size() < 3) {
            if (!computerNumbers.contains(number))
                computerNumbers.add(number);
        }
    }
}
