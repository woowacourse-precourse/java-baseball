package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public void simulate(){
        List<Integer> randomNumList = createNumber();
    }

    public List<Integer> createNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1,9);
            if (!numberList.contains(randomNum)) {
                numberList.add(randomNum);
            }
        }
        return numberList;
    }


}
