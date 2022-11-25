package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    private List<Integer> computerNumber;

    public Computer() {
        this.computerNumber = createComputerNumber();
    }

    private List<Integer> createComputerNumber() {
        validateComputerNumber(generateComputerNumber());
        return computerNumber;
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }


    private void validateComputerNumber(List<Integer> computerNumber) {
        if (hasDuplicates(computerNumber)) {
            throw new IllegalArgumentException("컴퓨터의 수에 중복된 숫자가 존재합니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> computerNumber) {
        return sizeOfDuplicatesRemoved(computerNumber) != computerNumber.size();
    }

    private int sizeOfDuplicatesRemoved(List<Integer> computerNumber) {
        return computerNumber.stream().collect(Collectors.toSet()).size();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}
