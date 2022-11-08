package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers;

    public Computer() {
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public void init() {
        do {
            generateNumbers();
        }while(!isValidateNumber(computerNumbers));
    }

    private void generateNumbers() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    private boolean isValidateNumber(List<Integer> numberList) {
        if (numberList.size() != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (numberList.get(i) < 1 || numberList.get(i) > 9) {
                return false;
            }
        }

        return true;
    }
}
