package baseball.Player;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class input {
    public static List<Integer> UserAnswer;
    public static List<Integer> StringtoList(String num) {
        List<Integer> UserAnswer = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            char curr = num.charAt(i);
            int currnum = curr - '0';
            UserAnswer.add(currnum);
        }
        return UserAnswer;
    }
    public static void isValiableAnswer() throws Exception{
        try {
            List<Integer> inputAnswer = StringtoList(Console.readLine());
            UserAnswer = inputAnswer;
            overNumber();
            checkdigits();
        }catch(Exception e) {
            throw new Exception("IllegalArgumentException");
        }

    }
    public static void overNumber() throws Exception {
        if(UserAnswer.size() != 3) {
            throw new Exception();
        }
    }
    public static void checkdigits() throws Exception {
        for(int i = 0; i < 3 ; i++) {
            for(int j = i+1; j < 3 ; j++) {
                if(UserAnswer.get(i) == UserAnswer.get(j)) {
                    throw new Exception();
                }
            }
        }
    }
}
