package baseball;

public class ExceptionBaseball {
    public final int USER_LENGTH_NOT_3 = 1;
    public final int ALPHA_IN_USER = 2;

    public int checkUserNumLength(String userNum) {
        if (userNum.length() == 3)
            return 0;
        else
            return USER_LENGTH_NOT_3;
    }

    public int checkUserNumAlpha(String userNum) {
        for (int index = 0; index < userNum.length(); index++) {
            if (!Character.isDigit(userNum.charAt(index)))
                return ALPHA_IN_USER;
        }
        return 0;
    }
}
