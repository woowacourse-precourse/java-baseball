package baseball.service;

import java.io.IOException;
import java.util.List;

public class AnswerCheck {
    public static String checkGuess(List<Integer> answer, List<Integer> guess) throws IOException {
        String check_result = "";
        int ball = 0;
        int strike = 0;

        if(answer.equals(guess)){
            check_result = "3스트라이크";
            return check_result;
        }else{
            int[] cntArray = new int[2];
            cntArray = cntBallStrike(answer, guess);
            ball = cntArray[0];
            strike = cntArray[1];
        }

        //출력문 구현
        if(ball==0&&strike==0){
            check_result = "낫싱";
        }else if(ball==0){
            check_result = strike+"스트라이크";
        }else if(strike==0){
            check_result = ball+"볼";
        }else{
            check_result = ball+"볼 "+strike+"스트라이크";
        }
        return check_result;
    }

    public static int[] cntBallStrike(List<Integer> answer, List<Integer> guess){
        int[] cnt = new int[2];    /*cnt[0]는 ball, cnt[1]는 strike*/

        for(Integer guess_num : guess){
            if(answer.contains(guess_num)){
                cnt[0]++;
            }
            if(answer.indexOf(guess_num)==guess.indexOf(guess_num)){
                cnt[0]--;
                cnt[1]++;
            }
        }
        return cnt;
    }
}
