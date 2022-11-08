package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> numbers;

    public User() {
        numbers = new ArrayList<>(3);
    }

    public void setUserNumbers(String input) {
        for (String number : input.split("")) {
            final int num = parsing(number);

            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자 3개가 입력되지 않았습니다.");
        }
    }

    private int parsing(String number) {
        int num;

        try {
            num = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 잘못 입력되었습니다.");
        }

        return num;
    }
}
