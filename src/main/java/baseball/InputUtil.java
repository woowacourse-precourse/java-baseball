package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    private static String userNumber="";

    public String inputUserName(){
        userNumber = Console.readLine();
        return userNumber;
    }
}
