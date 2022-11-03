package baseball.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private List<Integer> computerNumberList;

    public Computer() {
        this.computerNumberList = generateRandomThreeNumbers();

    }

    private List<Integer> generateRandomThreeNumbers() {

        List<Integer> numberList = new ArrayList<>();

        for (; ; ) {

            numberList.clear();

            for (; numberList.size() < 3; ) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                numberList.add(randomNumber);
            }

            if (isNotDuplication(numberList)) {
                break;
            }

        }

        return numberList;
    }

    private boolean isNotDuplication(List<Integer> numberList) {
        return numberList.size() == numberList.stream().distinct().count();
    }

    public List<Integer> getComputerNumberList() {
        return computerNumberList;
    }
}
