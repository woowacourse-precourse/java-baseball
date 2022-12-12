package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expectation {
    static final String STRIKE = "스트라이크";
    static final String BALL = "볼";

    private String expectedValue;

    private Map<String, Integer> score;

    public Expectation(String expectedValue,List<Integer> computer_num){
        this.expectedValue = expectedValue;
        checkScore(computer_num);
    }

    private void checkScore(List<Integer> computer_num) {
        HashMap<String, Integer> score = new HashMap<>();
        score.put(STRIKE,countStrikeScore(computer_num));
        score.put(BALL,countBallScore(computer_num));
        this.score = score;
    }

    private int countStrikeScore(List<Integer> computer_num){
        int cnt = 0;
        for (int i = 0; i < 3; i++){
            if (computer_num.get(i) == expectedValue.charAt(i) - '0'){
                cnt += 1;
            }
        }
        return cnt;
    }

    private int countBallScore(List<Integer> computer_num){
        int cnt = 0;
        for (int i = 0; i < 3; i++){
            if (computer_num.contains(expectedValue.charAt(i) - '0')){
                cnt += 1;
            }
        }
        return cnt;
    }

    public Map<String, Integer> getScore(){
        return this.score;
    }
}
