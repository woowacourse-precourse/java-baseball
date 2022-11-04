package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static int makeRandomNum(){
        List<Integer> randomDigitList = new ArrayList<>();
        while (randomDigitList.size() < 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (!randomDigitList.contains(randomDigit)) {
                randomDigitList.add(randomDigit);
            }
        }
        int randomNumber = randomDigitList.get(0)*100 + randomDigitList.get(1)*10 +randomDigitList.get(2);
        return randomNumber;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

