package validate;

import java.util.List;

public class check {
    public static void userListSize(List<Integer> user) {
        if (user.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

    public static boolean isNumberValidate(String userInput) {
        char check;

        if (userInput.equals("")) {
            return false;
        }

        for (int i = 0; i < userInput.length(); i++) {
            check = userInput.charAt(i);
            if (check < 48 || check > 58) {
                return false;
            }
        }

        return true;
    }

    public static boolean restartNumberValidate(int restart) {

        if (restart == 1) {
            return true;
        } else if (restart == 2) {
            return false;
        } else if (restart != 1 || restart != 2) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }

        return false;
    }
}
