package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            randomNumber.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumber;
    }

    public static void main(String[] args) {
    }
}
