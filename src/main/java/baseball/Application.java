package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

    }

    static int getRandomValue() {
        Set<Integer> set=new HashSet<>();
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (set.contains(random)) {
                i--;
            }else{
                result = result * 10 + random;
                set.add(random);
            }
        }
        return result;
    }
}
