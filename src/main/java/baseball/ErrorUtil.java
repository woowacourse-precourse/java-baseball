package baseball;

public class ErrorUtil {
    public boolean checkErrorRestartNumber(String number) {
        boolean error = true;
        if (number.length() != 1)
            error = false;
        else if (number.charAt(0) != '1' && number.charAt(0) != '2')
            error = false;
        return error;
    }
    public boolean errorPlayerNumber(String playerNumber) {
        boolean error = (playerNumber.length() == 3);
        for (int i=0;i<playerNumber.length();++i)
            if (playerNumber.charAt(i) < '1' || playerNumber.charAt(i) > '9') {
                error = false;
                break;
            }
        if (playerNumber.length() == 3 && ((playerNumber.charAt(0) == playerNumber.charAt(1))
                || (playerNumber.charAt(0) == playerNumber.charAt(2))
                || (playerNumber.charAt(1) == playerNumber.charAt(2))))
            error = false;
        return error;
    }
    public void checkError(boolean check) {
        if (!check)
            throw new IllegalArgumentException();
    }
}