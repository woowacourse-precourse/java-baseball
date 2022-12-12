package baseball;

import java.util.List;

public class Expectation {
    private int strikeScore;
    private int ballScore;
    private String expectedValue;

    public Expectation(String expectedValue,List<Integer> computer_num){
        this.expectedValue = expectedValue;
        checkScore(computer_num);
    }

    public void checkScore(List<Integer> computer_num) {
        this.strikeScore = countStrikeScore(computer_num);
        this.ballScore = countBallScore(computer_num);
    }

    public int countStrikeScore(List<Integer> computer_num){
        int cnt = 0;
        for (int i = 0; i < 3; i++){
            if (computer_num.get(i) == expectedValue.charAt(i) - '0'){
                cnt += 1;
            }
        }
        return cnt;
    }

    public int countBallScore(List<Integer> computer_num){
        int cnt = 0;
        for (int i = 0; i < 3; i++){
            if (computer_num.contains(expectedValue.charAt(i) - '0')){
                cnt += 1;
            }
        }
        return cnt;
    }
}
