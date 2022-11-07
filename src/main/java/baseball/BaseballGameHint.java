package baseball;

import java.util.List;

import static baseball.Const.ANSWER_MESSAGE;
import static baseball.Const.BALL_MESSAGE;
import static baseball.Const.NOTHING_MESSAGE;
import static baseball.Const.NUMBER_LENGTH;
import static baseball.Const.STRIKE_MESSAGE;

public class BaseballGameHint {

    private int ball;
    private int strike;

    public void getHint(List<Integer> expectedAnswer, List<Integer> answer){
        generateHint(expectedAnswer,answer);
        printHint();
    }

    private void generateHint(List<Integer> expectedAnswer, List<Integer> answer) {
        resetStrikeAndBall();

        for (int answerIndex  =0 ;answerIndex < NUMBER_LENGTH;answerIndex++) {
            int findIndex=answer.indexOf(expectedAnswer.get(answerIndex));

            if(findIndex!=-1) {
                checkStrikeOrBall(findIndex,answerIndex);
            }
        }
    }

    private void checkStrikeOrBall(int findIndex,int answerIndex){
        if(findIndex==answerIndex){
            strike++;
        }else{
            ball++;
        }
    }

    private void resetStrikeAndBall() {
        this.ball = 0;
        this.strike = 0;
    }

    public boolean isAnswer() {
        if (strike == 3) {
            System.out.println(ANSWER_MESSAGE);
            return true;
        }
        return false;
    }

    private void printHint() {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING_MESSAGE);
        }else if(ball > 0 && strike > 0){
            System.out.println(ball+BALL_MESSAGE+" "+strike+STRIKE_MESSAGE);
        }else if(ball > 0){
            System.out.println(ball+BALL_MESSAGE);
        }else if(strike > 0){
            System.out.println(strike+STRIKE_MESSAGE);
        }
    }
}
