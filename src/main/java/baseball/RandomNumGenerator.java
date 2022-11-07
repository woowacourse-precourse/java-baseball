package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumGenerator {
    public List<String> randomNumbers() {
        List<String> threeNumber = new ArrayList<>();

        while (threeNumber.size() < 3) {


            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!(threeNumber.contains(randomNumber))) {

                threeNumber.add(randomNumber);
            }
        }
        return threeNumber;
    }
}