package baseball.utils;

public class InputValidation {

    public boolean checkUserNumberLength(String usernumber) {
        boolean checkusernumber = true;
        if(usernumber.length() != 3) {
            checkusernumber = false;
        }
        return checkusernumber;
    }

    public boolean checkUsernumberDigit(String usernumber) {
        boolean checkusernumber = true;
        for(int i=0; i<usernumber.length(); i++) {
            int digit = usernumber.charAt(i) - '0';
            if (digit <= 0|| digit > 9) {
                checkusernumber = false;
            }
        }
        return checkusernumber;
    }
}
