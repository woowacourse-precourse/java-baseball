package baseball.utils;

public class InputValidation {
    public static final String REGAME = "1";
    private static final String END = "2";


    public boolean checkUserNumberLength(String usernumber) {
        return usernumber.length() == 3;
    }

    public boolean checkUsernumberDigit(String usernumber) {
        boolean checkusernumber = true;
        for(int i=0; i<usernumber.length(); i++) {
            int digit = usernumber.charAt(i) - '0';
            if (digit <= 0|| digit > 9) {
                checkusernumber = false;
                break;
            }
        }
        return checkusernumber;
    }

    public boolean checkSameUsernumber(String usernumber) {
        boolean checkusernumber = true;
        boolean[] checknumber = new boolean[10];

        for(int i=0; i<usernumber.length(); i++) {
            int digit = usernumber.charAt(i) - '0';
            if(!checknumber[digit]) {
                checknumber[digit] = true;
            }
            else {
                checkusernumber = false;
                break;
            }
        }
        return checkusernumber;
    }

    public boolean userInputValidation(String usernumber) {
        return checkUserNumberLength(usernumber) && checkUsernumberDigit(usernumber) && checkSameUsernumber(usernumber);
    }

    public void startOrEndValidation(String inputnumber) {
        if(!(inputnumber.equals(REGAME) || inputnumber.equals(END))) {
            throw new IllegalArgumentException();
        }
    }
}
