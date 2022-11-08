package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    private int randomNumber;

    public Computer(List<Integer> computerNum) {
        createComputerNum(computerNum);
    }

    void createComputerNum(List<Integer> computerNum) {
        while (computerNum.size() < 3) {
            randomNumber = createRandomNumber();
            addComputerNum(computerNum);
        }
    }

    int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    void addComputerNum(List<Integer> computerNum) {
        if (!computerNum.contains(randomNumber))
            computerNum.add(randomNumber);
    }
}
