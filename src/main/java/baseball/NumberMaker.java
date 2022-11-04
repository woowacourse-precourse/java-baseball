package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {

    public String makeRandomNumber() {
        String number = "";
        String randomValue = "";
        while (number.length() < 3) {
            randomValue = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!number.contains(randomValue)) {
                number += randomValue;
            }
        }
        return number;
    }

    public String makePlayerNumber() {
        String number = Console.readLine();
        return number;
    }

}
