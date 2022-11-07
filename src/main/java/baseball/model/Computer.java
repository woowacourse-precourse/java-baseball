package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numeralList = new ArrayList<>();
    public Computer() {
        generateComputerNumber();
    }

    private void generateComputerNumber(){
        while (numeralList.size() < Game.ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numeralList.contains(randomNumber)) {
                numeralList.add(randomNumber);
            }
        }
    }

}
