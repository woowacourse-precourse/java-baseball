package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class User {

    private static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final Pattern INPUT_REGEX = Pattern.compile("[0-9]{3,3}");
    int userNumber;

    public User() {}

    public void setUserNumber() {
        System.out.print(OUTPUT_ENTER_NUMBER);
        String input = Console.readLine();
        getValidation(input);
        this.userNumber = Integer.parseInt(input);
    }

    // method only for test code
    public void setUserNumber(String input) {
        getValidation(input);
        this.userNumber = Integer.parseInt(input);
    }

    public int getUserNumber() {
        return userNumber;
    }

    private void getValidation(String input) {
        boolean validation = getLengthValidation(input) && getTypeValidation(input);
        if(!validation) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean getTypeValidation(String input) {
        boolean checkType = INPUT_REGEX.matcher(input).matches();
        return checkType;
    }

    private static Boolean getLengthValidation(String input) {
        boolean checkLength = input.length() == 3;
        return checkLength;
    }


}
