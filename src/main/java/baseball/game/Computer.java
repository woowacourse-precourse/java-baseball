package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.game.Const.*;

public class Computer {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public void generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < GAME_LENGTH) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        this.numbers = numbers;
    }
}
