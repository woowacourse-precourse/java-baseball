package baseball.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private List<Integer> computerNumbers;

    public Computer() {
        this.computerNumbers = generateRandomThreeNumbers();
    }

    private List<Integer> generateRandomThreeNumbers() {

        List<Integer> numbers = new ArrayList<>();

        for (; ; ) {

            numbers.clear();

            for (; numbers.size() < 3; ) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                numbers.add(randomNumber);
            }

            if (isNotDuplication(numbers)) {
                break;
            }

        }

        return numbers;
    }

    private boolean isNotDuplication(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
