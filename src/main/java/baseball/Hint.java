package baseball;

import java.util.List;

public class Hint {
    private List<Integer> computerAnswer;
    private List<Integer> playerAnswer;
    private int strike;
    private int ball;

    public Hint(List<Integer> computerAnswer, List<Integer> playerAnswer, int strike, int ball) {
        this.computerAnswer = computerAnswer;
        this.playerAnswer = playerAnswer;
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
    public void compareNumber(List<Integer> playerNum, List<Integer> answer){
        for(int i=0;i<3;i++){
            countStrike(playerNum.get(i), answer.get(i));
            countBall(i, playerNum.get(i), answer);
        }
    }

    public void countStrike(int playerAnswer, int computerAnswer){
        if (playerAnswer == computerAnswer) {
            strike++;
        }
    }

    public void countBall(int index, int playerAnswer, List<Integer> answer){
        if(answer.contains(playerAnswer) && answer.indexOf(playerAnswer)!=index){
            ball++;
        }
    }



}
