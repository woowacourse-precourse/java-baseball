package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int NUM_SIZE = 3;

    private static List<Integer> makeComNum() {
        List<Integer> comNum = new ArrayList<>();
        for(int i = 0; i < NUM_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(randomNumber)) {
                comNum.add(randomNumber);
            }
        }
        return comNum;
    }



    public static void main(String[] args) {

    }
}
