package baseball;

import camp.nextstep.edu.missionutils.Console;
import utils.GameInputException;
import utils.RandomNumbers;

import java.util.List;
import java.util.ArrayList;

public class Baseball {
    private String userNumbers;
    private int numberLength;
    private List<Integer> computerNumber;
    GameInputException gameInputException;

    Baseball() {
        this(3);
    }

    Baseball(int numberLength) {
        this.numberLength = numberLength;
        gameInputException = new GameInputException(numberLength);
    }

    public void play() throws IllegalArgumentException{
        setComputerNumber();

        int strike = 0;
        int ball = 0;

        while (strike != numberLength) {
            setUserNumbers();

            gameInputException.checkUserInput(userNumbers);

            strike = getStrike();
            ball = getBall() - strike;

            printResult(strike, ball);
        }
    }

    private void setComputerNumber() {
        RandomNumbers randomNumbers = new RandomNumbers(numberLength);
        computerNumber = randomNumbers.getComputerNumbers();
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        List<String> resultSentence = new ArrayList<>();
        if (ball > 0) {
            resultSentence.add(ball + "볼");
        }

        if (strike > 0) {
            resultSentence.add(strike + "스트라이크");
        }

        System.out.println(String.join(" ",resultSentence));
    }

    private void setUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        userNumbers = Console.readLine();
    }

    private int getStrike() {
        int strikeNumber = 0;

        for (int numberIndex = 0; numberIndex < numberLength; numberIndex++) {
            int computer = computerNumber.get(numberIndex);

            char userCharacter = userNumbers.charAt(numberIndex);
            int user = Character.getNumericValue(userCharacter);

            strikeNumber = checkStrike(computer,user,strikeNumber);
        }

        return strikeNumber;
    }

    private int checkStrike(int computerNumber, int userNumber, int strike) {
        if (computerNumber == userNumber) {
            return ++strike;
        }

        return strike;
    }

    private int getBall() {
        int ballNumber = 0;
        for (int numberIndex = 0; numberIndex < numberLength; numberIndex ++) {
            char userCharacter = userNumbers.charAt(numberIndex);
            int user = Character.getNumericValue(userCharacter);

            ballNumber = checkBall(computerNumber,user,ballNumber);
        }

        return ballNumber;
    }

    private int checkBall(List<Integer> computerNumber, int userNumber, int ball) {
        if (computerNumber.contains(userNumber)) {
            return ++ball;
        }

        return ball;
    }
}
