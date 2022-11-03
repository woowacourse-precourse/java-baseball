package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private static final int NUMBER_COUNT = 3;

    private List<Integer> computerNumbers;

    public void setRandomNumbers() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            this.computerNumbers.add(randomNumber);

            if (!isRandomNumbersUnique(this.computerNumbers)) {
                int randomNumberIndex = this.computerNumbers.size() - 1;
                this.computerNumbers.remove(randomNumberIndex);
            }
        }
    }

    public List<Integer> getComputerNumbers() {
        return this.computerNumbers;
    }

    public boolean isRandomNumbersUnique(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        return distinctNumbers.equals(numbers);
    }
}
