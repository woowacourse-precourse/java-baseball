package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int DIGITS = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    List<Integer> numbers;
    boolean[] checkNumbers;

    public void pickRandomNumbers() {
        numbers = new ArrayList<>();
        checkNumbers = new boolean[9];

        while (numbers.size() < DIGITS) {
            int pickedNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            if (checkDuplicate(pickedNumber)) {
                continue;
            }
            numbers.add(pickedNumber);
            checkNumbers[pickedNumber - 1] = true;
        }
    }

    private boolean checkDuplicate(int number) {
        return checkNumbers[number - 1];
    }

    public Hint checkCounts(List<Integer> playerNumbers) {
        Hint hint = new Hint();

        for (int i = 0; i < numbers.size(); i++) {
            int computerNumber = numbers.get(i);
            int playerNumber = playerNumbers.get(i);

            if (checkStrike(computerNumber, playerNumber)) {
                hint.increaseStrike();
            } else if (checkBall(playerNumber)) {
                hint.increaseBall();
            }
        }
        return hint;
    }

    private boolean checkStrike(int computerNumber, int playerNumber) {
        return computerNumber == playerNumber;
    }

    private boolean checkBall(int playerNumber) {
        return checkNumbers[playerNumber - 1];
    }
}
