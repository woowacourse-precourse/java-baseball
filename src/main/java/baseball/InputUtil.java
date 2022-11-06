package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    public List<String> inputUserNumber(){
        CheckUtil checkUtil = new CheckUtil();

        String userNumber = Console.readLine();
        List<String> userNumList = stringToListString(userNumber);

        checkUtil.checkIsValidDigit(userNumber);
        checkUtil.checkIsValidLength(userNumber.length());
        checkUtil.checkIsDuplicated(userNumList);

        return userNumList;
    }

    private List<String> stringToListString(String userNumber){
        List<String> userNumList = new ArrayList<>();
        for(char c:userNumber.toCharArray()){
            userNumList.add(Character.toString(c));
        }
        return userNumList;
    }
}
