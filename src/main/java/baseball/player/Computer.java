package baseball.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private List<Integer> computerNumberList;

    public Computer() {
        this.computerNumberList = generateRandomThreeNumbers();
    }

    private List<Integer> generateRandomThreeNumbers() {

        List<Integer> numberList = new ArrayList<>();

        for (; computerNumberList.size() < 3; ) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(isNotDuplication(numberList)){
                numberList.add(randomNumber);
            }

        }

        return numberList;
    }

    private boolean isNotDuplication(List<Integer> numberList) {
        return numberList.size() != numberList.stream().distinct().count();
    }

    public List<Integer> getComputerNumberList() {
        return computerNumberList;
    }
}
