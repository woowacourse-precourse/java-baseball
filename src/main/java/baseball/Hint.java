package baseball;

import java.util.List;

public class Hint {
    private List<Integer> playerAnswer;
    private List<Integer> computerAnswer;
    private int strike;
    private int ball;

    public Hint(List<Integer> playerAnswer, List<Integer> computerAnswer, int strike, int ball) {
        this.playerAnswer = playerAnswer;
        this.computerAnswer = computerAnswer;
        this.strike = 0;
        this.ball = 0;
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

    public void makeHint(int strike, int ball) {
        String hint = "";
        if (strike == 0 && ball == 0) {
            hint = Message.NOTHING.getMessage();
        }
        else if (strike == Range.DIGIT) {
            hint = Message.END_GAME.getMessage();
            System.out.println(Message.END_GAME);
        }
        else if (ball != 0) {
            hint += ball + Message.BALL.getMessage();
        }
        else if (strike != 0) {
            hint += strike + Message.STRIKE.getMessage();
        }
        System.out.println(hint);
    }


}
