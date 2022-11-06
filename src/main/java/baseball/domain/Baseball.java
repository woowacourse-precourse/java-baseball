package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baseball {
    private List<Integer> computer;
    private List<Integer> userNumber;

    public Baseball() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> setUserNumber(String number) {
        if (isException(number)) {
            throw new IllegalArgumentException();
        }
        userNumber = new ArrayList<>();
        for (int index = 0; index < number.length(); index++) {
            userNumber.add(Integer.valueOf(number.charAt(index) - '0'));
        }
        return userNumber;
    }

    private boolean isException(String number) {
        if (number.length() != 3) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < number.length(); index++) {
            int charNumber = number.charAt(index) - '0';
            if (charNumber < 0 || charNumber > 9) {
                return true;
            }
            if (set.contains(charNumber)) {
                return true;
            }
            set.add(charNumber);
        }
        return false;
    }


    public List<Integer> estimateScore() {
        List<Integer> count = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            count.add(0);
        }
        for (int index = 0; index < userNumber.size(); index++) {
            if (computer.indexOf(userNumber.get(index)) == -1) {
                count.set(2, count.get(2) + 1);
                continue;
            }
            if (computer.indexOf(userNumber.get(index)) == index) {
                count.set(1, count.get(1) + 1);
                continue;
            }
            count.set(0, count.get(0) + 1);
        }
        return count;
    }

    public boolean inputControllNumber(String readLine) {
        if (isExceptionControllNumber(readLine)) {
            throw new IllegalArgumentException();
        }
        if (readLine.equals("1")) {
            return true;
        }
        return false;
    }

    private boolean isExceptionControllNumber(String str) {
        if (str.length() != 1) {
            return true;
        }
        int charNumber = str.charAt(0) - '0';
        if (charNumber != 1 && charNumber != 2) {
            return true;
        }

        return false;
    }
}
