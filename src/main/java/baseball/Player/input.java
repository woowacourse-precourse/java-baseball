package baseball.Player;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class input {
    public List<Integer> StringtoList(String num) {
        List<Integer> UserAnswer = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            char curr = num.charAt(i);
            int currnum = curr - '0';
            UserAnswer.add(currnum);
        }
        return UserAnswer;
    }
    public void isValiableAnswer() {
        try {
            List<Integer> UserAnswer = StringtoList(Console.readLine());
        }catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
