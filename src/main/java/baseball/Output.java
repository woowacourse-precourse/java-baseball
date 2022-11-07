package baseball;

import java.util.ArrayList;

public class Output {
    Compare compare = new Compare();

    public String judgeResult(ArrayList<Integer> answerNumList, ArrayList<Integer> playerNumList) {
        int total = compare.getMatchResult(answerNumList, playerNumList);
        int strike = compare.strikeCount(answerNumList, playerNumList);
        int ball = total - strike;

        if(total == 0) {
            return "낫싱";
        } else if(strike == 0) {
            return ball + "볼";
        } else if(ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
