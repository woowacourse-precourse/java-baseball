package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class GameReadyMachine {
    private int answerValue;

    public boolean checkDigitValue(int value) {
        int hundredDigits = value / 100;
        value = value % 100;
        int tensDigits = value / 10;
        value = value % 10;
        int oneDigits = value;

        if (hundredDigits == tensDigits) {
            return false;
        } else if (tensDigits == oneDigits) {
            return false;
        } else if (hundredDigits == oneDigits) {
            return false;
        } else {
            return true;
        }
    }

    public boolean setAnswerValue() {
        answerValue = Randoms.pickNumberInRange(100, 999);
        if (answerValue >= 100 || answerValue <= 999)
            return true;
        else
            return false;
    }


}

public class Application {
    public static void main(String[] args) {

    }
}
