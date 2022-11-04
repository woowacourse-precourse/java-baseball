package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class UserNumber {
    String REGEX = "[0-9]{3,3}";
    int userNumber;

    public UserNumber() {}

    public void setUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        getValidation(input);
        this.userNumber = Integer.parseInt(input);

    }

    public void setUserNumber(String input) {
        getValidation(input);
        this.userNumber = Integer.parseInt(input);
    }

    private void getValidation(String input) {
        Boolean checkLength = getLengthValidation(input);
        Boolean checkType = getTypeValidation(input);
        Boolean validation = checkLength && checkType;
        if(!validation) {
            throw new IllegalArgumentException();
        }
    }

    private Boolean getTypeValidation(String input) {
        Boolean checkType = Pattern.matches(REGEX, input);
        return checkType;
    }

    private static Boolean getLengthValidation(String input) {
        Boolean checkLength = input.length() == 3;
        return checkLength;
    }


}
