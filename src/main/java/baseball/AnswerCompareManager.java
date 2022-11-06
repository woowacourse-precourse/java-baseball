package baseball;

public class AnswerCompareManager {
    public static boolean compareAnswer(int answer, int input) {
        int ballNum = 0, strikeNum = 0;
        String answerStr = String.valueOf(answer);
        String inputStr = String.valueOf(input);

        // 별도 메서드로 분리
        for(int idx = 0; idx < GameConfig.ANSWER_LEN; idx++) {
            char digit = inputStr.charAt(idx);
            String digitStr = inputStr.substring(idx, idx+1);

            if(answerStr.charAt(idx) == digit)
                strikeNum++;
            else if(answerStr.contains(String.valueOf(digitStr)))
                ballNum++;
        }

        IOManager.getHint(ballNum, strikeNum);

        return strikeNum == 3;
    }
}
