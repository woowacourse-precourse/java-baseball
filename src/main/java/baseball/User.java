package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {


    public List userInput() throws IllegalArgumentException{
        String str = Console.readLine();
        if (userInputValidate) {
            throw new IllegalArgumentException() ;
        }
        return StringToNumberList(str);
    }
    private static List StringToNumberList(String str) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            result.add(str.charAt(i) - '0');
        }
        return result;
    }
}