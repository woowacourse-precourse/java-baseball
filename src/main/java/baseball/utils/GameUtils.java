package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameUtils {

    public static List<Integer> generateNonDuplicatedRandomNumberList(int startNumber, int endNumber, int listSize){
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < listSize){
            int randomNumber = Randoms.pickNumberInRange(startNumber, endNumber);
            if(!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

}
