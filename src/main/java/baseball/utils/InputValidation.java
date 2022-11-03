package baseball.utils;

public class InputValidation {

    public boolean checkUserNumberLength(String usernumber) {
        boolean checkusernumber = true;
        if(usernumber.length() != 3) {
            checkusernumber = false;
        }
        return checkusernumber;
    }
}
