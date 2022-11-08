package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberManagement {
    
    public static List<Integer> randomNumberMake(int loopFrequency) {
        List<Integer> randomList = new ArrayList<>();
        while(randomList.size()<=loopFrequency) {
            int checkNumber = Randoms.pickNumberInRange(1,9);
            if (!randomList.contains(checkNumber)) {
                randomList.add(checkNumber);
            }
        }
        return randomList;
    }
}
