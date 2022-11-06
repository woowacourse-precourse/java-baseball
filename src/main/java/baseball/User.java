package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class User {

    String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    String REGEX = "[0-9]{3,3}";
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
        boolean checkLength = getLengthValidation(input);
        boolean checkType = getTypeValidation(input);
        boolean validation = checkLength && checkType;
        if(!validation) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean getTypeValidation(String input) {
        boolean checkType = Pattern.matches(REGEX, input);
        return checkType;
    }

    private static Boolean getLengthValidation(String input) {
        boolean checkLength = input.length() == 3;
        return checkLength;
    }


}
