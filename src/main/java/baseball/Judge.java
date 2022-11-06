package baseball;

import java.util.List;

public class Judge {
    private int ball = 0;
    private int strike = 0;
    
    private void countBall(List<Integer> answer, List<Integer> userNumber) {
        for(int n : userNumber){
            if(answer.contains(n))
                this.ball++;
        }
    }

    private void countStrike(List<Integer> answer, List<Integer> userNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            if (answer.get(i) == answer.get(i)) {
                this.strike++;
                this.ball--;
            }
        }
    }
    public String judgement(List<Integer> answer, List<Integer> userNumber) {
        this.countBall(answer, userNumber);
        this.countStrike(answer, userNumber);
        
        if(ball == 0 && strike == 0)
            return "낫싱";
        
        else if(strike == 0) 
            return this.ball + "볼";
        
        else if(ball == 0)
            return this.strike + "볼";
        
        else return this.ball + "볼" + this.strike + "스트라이크";
    }
    
    public int getStrike() {
        return this.strike;
    }
    
    public void truncateMembers() {
        this.ball = 0;
        this.strike = 0;        
    }
}
