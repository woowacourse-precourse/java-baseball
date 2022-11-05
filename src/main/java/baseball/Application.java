package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class GameReadyMachine {
    private int answerValue = 100;

    public int setAnswerValue() {
        this.setValue();
        while (!checkDigitValue(this.answerValue)) {
            this.setValue();
        }
        return answerValue;
    }

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

    public boolean setValue() {
        answerValue = Randoms.pickNumberInRange(100, 999);
        if (answerValue >= 100 || answerValue <= 999)
            return true;
        else
            return false;
    }

    public void gameReadyComplete()
    {
        this.setAnswerValue();
        System.out.printf("숫자 야구 게임을 시작합니다.\n");
    }

    public int getAnswerValue()
    {
        return answerValue;
    }
}

class GameProcessor{
    private String lastInput=null;
    public String userInput()
    {
        lastInput=Console.readLine();
        return lastInput;
    }
    public String getLastInput(){
        return lastInput;
    }
}
public class Application {
    public static void main(String[] args) {

    }
}
