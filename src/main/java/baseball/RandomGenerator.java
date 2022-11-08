package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RandomGenerator {

    //public static final int CORRECT_INPUT_LENGTH = 3;

    public static RandomNumber generateRandom(StringBuilder sb, ArrayList<Integer> generateRandNum, int inputLength) {
        while (generateRandNum.size() < inputLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generateRandNum.contains(randomNumber)) {
                generateRandNum.add(randomNumber);
                sb.append(Integer.toString(randomNumber));
            }
        }
        System.out.println("RANDOM VAL IS : " + sb);
        return new RandomNumber(sb.toString());
    }
}
