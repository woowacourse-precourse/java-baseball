package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer extends Gamer {

    public void setRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computerNumbers.add(randomNumber);

            if (!isNumbersUnique(computerNumbers)) {
                int randomNumberIndex = computerNumbers.size() - 1;
                computerNumbers.remove(randomNumberIndex);
            }
        }

        super.setNumbers(computerNumbers);
    }

    public boolean isNumbersUnique(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        return distinctNumbers.equals(numbers);
    }
}
