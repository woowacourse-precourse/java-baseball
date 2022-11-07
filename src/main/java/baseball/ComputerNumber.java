package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class ComputerNumber {

    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static List<Integer> computerGetList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = getRandomNumber();
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

}


