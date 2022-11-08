package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class User {

    private static final String OUTPUT_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final Pattern INPUT_REGEX = Pattern.compile("[1-9]{3,3}");
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
        getLengthValidation(input);
        getTypeValidation(input);
    }

    private void getTypeValidation(String input) {
        if(!INPUT_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private static void getLengthValidation(String input) {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }


}
