package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNumber {
    String REGEX = "[0-9]{3,3}";
    int userNumber;

    public UserNumber() {}

    public void setUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        // validation
        Boolean checkLength = input.length() == 3;
        System.out.println("CheckLength :" + checkLength);

        // 세 자리 자연수인지 확인
        Boolean checkType = Pattern.matches(REGEX, input);
        System.out.println("CheckType :" + checkType);

        Boolean validation = checkLength && checkType;
        if(!validation) {
            throw new IllegalArgumentException();
        }

        this.userNumber = Integer.parseInt(input);

    }

    // override method for test
    public void setUserNumber(String input) {

        // validation

        // 세 자리인지 확인
        Boolean checkLength = input.length() == 3;
        System.out.println("CHECK1 :" + checkLength);

        // 세 자리 자연수인지 확인
        Boolean checkType = Pattern.matches(REGEX, input);
        System.out.println("CHECK2 :" + checkType);

        Boolean validation = checkLength && checkType;
        if(!validation) {
            throw new IllegalArgumentException();
        }

        this.userNumber = Integer.parseInt(input);
    }






}
