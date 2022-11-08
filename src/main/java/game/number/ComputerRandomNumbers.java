package game.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumbers extends ThreeNumbers {
    private final List<Integer> computerRandomNumbers = new ArrayList<>();

    public ComputerRandomNumbers() {
        createThreeNumbers();
    }

    @Override
    void createThreeNumbers() {
        for (int i = 0; i < 3; ++i) {
            addNumber();
        }
    }

    void addNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerRandomNumbers.contains(randomNumber)) {
            computerRandomNumbers.add(randomNumber);
        }
    }

    public boolean contains(int number) {
        return computerRandomNumbers.contains(number);
    }

    public int getIndex(int number) {
        return computerRandomNumbers.indexOf(number);
    }
}
