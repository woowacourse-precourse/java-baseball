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
    private int lastInputInt = -1;
    private int strike = 0;
    private int ball = 0;
    private int[] userValue = {-1, -1, -1};
    private int[] computerValue = {-1, -1, -1};

    public int getLastInputInt() {
        return lastInputInt;
    }

    public int[] getUserValue() {
        return userValue;
    }

    public int[] getComputerValue() {
        return computerValue;
    }

    public void toArrayValue(int userInput, int computerInput) {
        String userString = String.valueOf(userInput);
        String computerString = String.valueOf(computerInput);

        for (int digit = 0; digit < 3; digit++) {
            userValue[digit] = Integer.parseInt(userString.substring(digit, digit + 1));
            computerValue[digit] = Integer.parseInt(computerString.substring(digit, digit + 1));
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
        System.out.print("숫자를 입력해주세요 : ");
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
            num = lastInputInt;
        } catch (NumberFormatException n) {
            throw new IllegalArgumentException();
        }

    }

    final int USER_USED_NUMBER = -1;
    final int COMPUTER_USED_NUMBER = -2;

    public void strikeChecker(int[] userValue, int[] computerValue) {
        int strikeCount = 0;
        if (userValue[0] == computerValue[0]) {
            strikeCount++;
            userValue[0] = USER_USED_NUMBER;
            computerValue[0] = COMPUTER_USED_NUMBER;
        }
        if (userValue[1] == computerValue[1]) {
            strikeCount++;
            userValue[1] = USER_USED_NUMBER;
            computerValue[1] = COMPUTER_USED_NUMBER;
        }
        if (userValue[2] == computerValue[2]) {
            strikeCount++;
            userValue[2] = USER_USED_NUMBER;
            computerValue[2] = COMPUTER_USED_NUMBER;
        }
        this.setStrike(strikeCount);
    }

    public void ballChecker(int[] userValue, int[] computerValue) {
        int ballCount = 0;
        for (int computerValueDigit = 0; computerValueDigit < 3; computerValueDigit++) {
            if (userValue[0] == computerValue[computerValueDigit]) {
                ballCount++;
                userValue[0] = USER_USED_NUMBER;
                computerValue[computerValueDigit] = COMPUTER_USED_NUMBER;
            }
            if (userValue[1] == computerValue[computerValueDigit]) {
                ballCount++;
                userValue[1] = USER_USED_NUMBER;
                computerValue[computerValueDigit] = COMPUTER_USED_NUMBER;
            }
            if (userValue[2] == computerValue[computerValueDigit]) {
                ballCount++;
                userValue[2] = USER_USED_NUMBER;
                computerValue[computerValueDigit] = COMPUTER_USED_NUMBER;
            }
        }
        this.setBall(ballCount);
    }

    public boolean isWin() {
        if (getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            stringMaker();
            return false;
        }

    }

    public void stringMaker() {
        StringBuilder stringBuilder = new StringBuilder();
        if (getStrike() > 0) {
            stringBuilder.append(getStrike() + "스트라이크");
        }
        if (getBall() > 0) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append(" ");

            }
            stringBuilder.append(getBall() + "볼");
        }
    }
}

class GameFinisher {
    boolean restartTrigger = true;

    GameFinisher() {
        restartTrigger = true;

    }


    public boolean isRestartTrigger() {
        return restartTrigger;
    }

    public void reStartChecker() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endValue = Console.readLine();
        if (endValue.equals("1")) {
            restartTrigger = true;
        } else if (endValue.equals("2")) {
            //later add 3-3 method
        } else {
            throw new IllegalArgumentException();
        }

    }
}

public class Application {

    public static void main(String[] args) {
        GameReadyMachine gameReadyMachine = new GameReadyMachine();
        GameProcessor gameProcessor = new GameProcessor();
        GameFinisher gameFinisher = new GameFinisher();

        while(gameFinisher.isRestartTrigger()) {
            gameReadyMachine.gameReadyComplete();
            gameProcessor.userInput();
            gameProcessor.checkInput();
            gameProcessor.toArrayValue(gameProcessor.getLastInputInt(), gameReadyMachine.getAnswerValue());
            gameProcessor.strikeChecker(gameProcessor.getUserValue(), gameProcessor.getComputerValue());
            gameProcessor.ballChecker(gameProcessor.getUserValue(), gameProcessor.getComputerValue());
            if (gameProcessor.isWin()) {

            }
            else {

            }
        }
    }

}
