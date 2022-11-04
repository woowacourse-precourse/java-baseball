package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    static List<Integer> randomNumberList;

    public void pickThreeNumbersRandomly() {
        randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        System.out.println(randomNumberList);
    }

    public String randomNumberListToString() {
        String randomNumber = "";

        for (Integer item : randomNumberList) {
            randomNumber += item;
        }

        return randomNumber;
    }
}
