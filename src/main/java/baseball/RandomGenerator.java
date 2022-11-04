package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;


public class RandomGenerator {
    public static int getRandomNumber(int length){
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int number = 0;
        for (Integer value : computer) {
            number*=10;
            number+=value;
        }
        return number;
    }
}
