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

            if(isDuplication(numberList)){
                continue;
            }

            numberList.add(randomNumber);

        }

        return numberList;
    }



}
