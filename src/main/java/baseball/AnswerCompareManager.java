package baseball;

import baseball.config.GameConfig;

public class AnswerCompareManager {
    private int ballNum = 0, strikeNum = 0;

    public boolean compareAnswer(int answer, int input) {
        compareStr(String.valueOf(answer), String.valueOf(input));

        IOManager.getHint(ballNum, strikeNum);

        return strikeNum == GameConfig.ANSWER_LEN;
    }

    private void compareStr(String answerStr, String inputStr) {
        for(int idx = 0; idx < GameConfig.ANSWER_LEN; idx++) {
            char digit = inputStr.charAt(idx);
            String digitStr = inputStr.substring(idx, idx+1);

            if(answerStr.charAt(idx) == digit) {
                strikeNum++;
            }
            else if(answerStr.contains(String.valueOf(digitStr))) {
                ballNum++;
            }

        }
    }
}
