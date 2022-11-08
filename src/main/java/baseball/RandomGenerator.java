package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RandomGenerator {

    public static RandomNumber generateRandom(StringBuilder sb, ArrayList<Integer> generateRandNum, int inputLength) {
        while (generateRandNum.size() < inputLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generateRandNum.contains(randomNumber)) {
                generateRandNum.add(randomNumber);
                sb.append(randomNumber);
            }
        }
        return new RandomNumber(sb.toString());
    }
}
