package baseball;

import java.util.ArrayList;
import java.util.List;

public class AnswerCompareManager {
    public static boolean compareAnswer(int answer, int input) {
        int ballNum = 0, strikeNum = 0;
        String answerStr = String.valueOf(answer);
        String inputStr = String.valueOf(input);

        for(int idx = 0; idx < 3; idx++) {
            char digit = inputStr.charAt(idx);
            String digitStr = inputStr.substring(idx, idx+1);

            if(answerStr.charAt(idx) == digit)
                strikeNum++;
            else if(answerStr.contains(String.valueOf(input)))
                ballNum++;
        }

        IOManager.getHint(ballNum, strikeNum);

        return strikeNum == 3;
    }
}
