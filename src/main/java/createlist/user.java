package createlist;

import java.util.ArrayList;
import java.util.List;

import static validate.check.userListSize;
import static validate.check.isNumberValidate;


public class user {
    public static List<Integer> UserNumber(String number) {
        List<Integer> user = new ArrayList<>();

        if (isNumberValidate(number) == false) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        for (int i = 0; i < number.length(); i++) {
            int numberToInt = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (user.contains(numberToInt)) {
                throw new IllegalArgumentException("중복된 숫자는 잘못된 입력값입니다.");
            }
            user.add(numberToInt);
        }

        userListSize(user);

        return user;
    }
}
