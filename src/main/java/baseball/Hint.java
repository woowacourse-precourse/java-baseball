package baseball;

import java.util.List;

public class Hint {
    private int strike;
    private int ball;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    private void initCount(){
        strike = 0;
        ball = 0;
    }

    public String compareNumber(List<Integer> playerNum, List<Integer> answer){
        initCount();
        for(int i=0;i<Range.DIGIT;i++){
            countStrike(playerNum.get(i), answer.get(i));
            countBall(i, playerNum.get(i), answer);
        }
        return makeHint(strike, ball);
    }

    public int getStrike() {
        return strike;
    }

    private void countStrike(int playerAnswer, int computerAnswer){
        if (playerAnswer == computerAnswer) {
            strike++;
        }
    }

    private void countBall(int index, int playerAnswer, List<Integer> answer){
        if(answer.contains(playerAnswer) && answer.indexOf(playerAnswer)!=index){
            ball++;
        }
    }

    private String makeHint(int strike, int ball) {
        String hint = "";
        if (strike == 0 && ball == 0) {
            hint = Message.NOTHING.getMessage();
        }
        if (ball != 0) {
            hint += ball + Message.BALL.getMessage();
        }
        if (strike!=0) {
            hint += strike + Message.STRIKE.getMessage();
        }
        if (strike == Range.DIGIT) {
            hint += "\n"+Message.END_GAME.getMessage();
        }
        return hint;
    }


}
