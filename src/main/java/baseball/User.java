package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class User {

    static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static final int NUMBER_LENGTH = 3;
    static final int FIRST_NUM = 1;
    static final int LAST_NUM = 9;

    public List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();

        System.out.print(INPUT_MESSAGE);
        String inputValue = Console.readLine();

        for (int i = 0; i < inputValue.length(); i++) {
            userNumber.add(Integer.parseInt(inputValue.substring(i, i + 1)));
        }

        validateUserNumber(userNumber);
        return userNumber;
    }

    public boolean validateUserNumber(List<Integer> num) {
        if (checkLength(num) && checkRange(num) && checkEachDifferent(num)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkLength(List<Integer> num) {
        return num.size() == NUMBER_LENGTH;
    }

    public boolean checkRange(List<Integer> num) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            if (FIRST_NUM <= num.get(i) && num.get(i) <= LAST_NUM) {
                cnt += 1;
            }
        }

        if (cnt == NUMBER_LENGTH) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkEachDifferent(List<Integer> num) {
        HashSet<Integer> setNum = Sets.newHashSet(num);

        return setNum.size() == num.size();
    }
}
