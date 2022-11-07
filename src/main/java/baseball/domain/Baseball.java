package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baseball {
    private List<Integer> computer;
    private List<Integer> userNumber;
    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int NOTHING = 2;
    private static final int THREE_DIGIT_NUMBER = 3;

    public Baseball() {
        computer = new ArrayList<>();
        while (computer.size() < THREE_DIGIT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> inputUserNumber(String number) {
        if (!isUserNumber(number)) {
            throw new IllegalArgumentException();
        }
        userNumber = new ArrayList<>();
        for (int digit = 0; digit < THREE_DIGIT_NUMBER; digit++) {
            userNumber.add(number.charAt(digit) - '0');
        }
        return userNumber;
    }

    private boolean isUserNumber(String number) {
        if (number.length() != THREE_DIGIT_NUMBER) {
            return false;
        }
        Set<Integer> digitset = new HashSet<>();
        for (int digit = 0; digit < THREE_DIGIT_NUMBER; digit++) {
            int digitNumber = number.charAt(digit) - '0';
            if (digitNumber < 0 || digitNumber > 9) {
                return false;
            }
            if (digitset.contains(digitNumber)) {
                return false;
            }
            digitset.add(digitNumber);
        }
        return true;
    }

    public List<Integer> playGame() {
        List<Integer> hints = Arrays.asList(0, 0, 0);
        for (int digit = 0; digit < THREE_DIGIT_NUMBER; digit++) {
            if (computer.indexOf(userNumber.get(digit)) == -1) {
                hints.set(NOTHING, hints.get(NOTHING) + 1);
                continue;
            }
            if (computer.indexOf(userNumber.get(digit)) == digit) {
                hints.set(STRIKE, hints.get(STRIKE) + 1);
                continue;
            }
            hints.set(BALL, hints.get(BALL) + 1);
        }
        return hints;
    }

    public boolean inputControllNumber(String readLine) {
        if (!isControllNumber(readLine)) {
            throw new IllegalArgumentException();
        }
        return readLine.equals("1");
    }

    private boolean isControllNumber(String digit) {
        if (digit.length() != 1) {
            return false;
        }
        int number = digit.charAt(0) - '0';
        if (number != 1 && number != 2) {
            return false;
        }
        return true;
    }
}
