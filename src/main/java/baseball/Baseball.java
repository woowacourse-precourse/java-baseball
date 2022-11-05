package baseball;

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
}
