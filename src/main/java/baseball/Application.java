package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> PickRandomNumber(){
        List<Integer> Number = new ArrayList<>();
        while (Number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Number.contains(randomNumber)) {
                Number.add(randomNumber);
            }
        }
        return Number;
    }
    public static void main(String[] args) {
            List<Integer> RandomNumber = PickRandomNumber();


    }
}
