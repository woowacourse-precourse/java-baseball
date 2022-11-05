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

    public void gameReadyComplete() {
        this.setAnswerValue();
        System.out.printf("숫자 야구 게임을 시작합니다.\n");
    }

    public int getAnswerValue() {
        return answerValue;
    }
}

class GameProcessor {
    private String lastInput = null;
    private int strike = 0;
    private int ball = 0;
    private int[] userValue = {-1, -1, -1};
    private int[] computerValue = {-1, -1, -1};

    public int[] getUserValue() {
        return userValue;
    }

    public int[] getComputerValue() {
        return computerValue;
    }

    public void toArrayValue(int userInput,int computerInput)
    {
        String userString = String.valueOf(userInput);
        String computerString = String.valueOf(computerInput);

        for(int digit=0;digit<3;digit++) {
            userValue[digit] = Integer.parseInt(userString.substring(digit,digit+1));
            computerValue[digit] = Integer.parseInt(computerString.substring(digit,digit+1));
        }
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }


    public String userInput() {
        lastInput = Console.readLine();
        return lastInput;
    }

    public String getLastInput() {
        return lastInput;
    }

    public void checkInput() {
        try {
            int num = Integer.parseInt(getLastInput());
            if (num < 100 || num > 999) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException();
        }
    }


    public void strikeChecker(int[] userValue,int[] computerValue) {
        int strikeCount = 0;
        if (userValue[0]==computerValue[0]) {
            strikeCount++;
        }
        if (userValue[1]==computerValue[1]) {
            strikeCount++;
        }
        if (userValue[2]==computerValue[2]) {
            strikeCount++;
        }
        this.setStrike(strikeCount);
    }

    public void ballChecker(int userValue, int computerValue) {

    }
}

public class Application {
    public static void main(String[] args) {


    }

}
