package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {


    public static List<String> inputUserNumber(){
        CheckUtil checkUtil = new CheckUtil();

        String userNumber = Console.readLine();

        List<String> userNumList = new ArrayList<>();
        for(char c:userNumber.toCharArray()){
            userNumList.add(Character.toString(c));
        }

        checkUtil.checkIsValidDigit(userNumber);
        checkUtil.checkIsValidLength(userNumber.length());
        checkUtil.checkIsDuplicated(userNumList);

        return userNumList;
    }
}
