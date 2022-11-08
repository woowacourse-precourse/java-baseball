package baseball;

import java.util.List;

public class ExceptionBaseball {
    public static final boolean USER_LENGTH_NOT_3 = true;
    public static final boolean ALPHA_IN_USER = true;

    public static boolean checkUserNumLength(String userNum) {
        if (userNum.length() == 3)
            return false;
        else
            return USER_LENGTH_NOT_3;
    }

    public static boolean checkUserNumAlpha(String userNum) {
        for (int index = 0; index < userNum.length(); index++) {
            if (!Character.isDigit(userNum.charAt(index)))
                return ALPHA_IN_USER;
        }
        return false;
    }
}
