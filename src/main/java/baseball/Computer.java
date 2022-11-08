package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    private final ArrayList<Integer> numbers;
    private static final int MAX_SIZE = 3;

    public Computer() {
        this.numbers = makeRandomNumbers();
    }

    public ArrayList<Integer> makeRandomNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }
}
