package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    private static String userNumber="";

    public static String inputUserNumber(){
        CheckUtil checkUtil = new CheckUtil();

        userNumber = Console.readLine();

        checkUtil.checkIsValidDigit(userNumber);
        checkUtil.checkIsValidLength(userNumber.length());
        checkUtil.checkIsDuplicated(userNumber);

        return userNumber;
    }
}
