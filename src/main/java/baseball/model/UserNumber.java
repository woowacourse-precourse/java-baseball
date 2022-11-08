package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private static final int NUMBER_SIZE = 3;

    private List<Integer> userNumbers = new ArrayList<>();

    public List<Integer> get() {
        return this.userNumbers;
    }

    public void set(String number) {
        validNumber(number);
        userNumbers.clear();

        for (int i = 0; i < NUMBER_SIZE; i++) {
            int userNumber = Integer.parseInt(number.substring(i, i + 1));

            userNumbers.add(userNumber);
        }
    }

    private void validNumber(String number) {
        if (number.length() != NUMBER_SIZE)
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");

        if (!number.matches("^[1-9]*$"))
            throw new IllegalArgumentException("0을 제외한 1~9 사이의 숫자를 입력해야 합니다.");

        String str = "";

        for (int i = 0; i < NUMBER_SIZE; i++) {
            String numberOfIndex = number.substring(i, i + 1);

            if (str.contains(numberOfIndex))
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해야 합니다.");

            str += numberOfIndex;
        }
    }
}
