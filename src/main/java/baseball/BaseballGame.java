package baseball;

public class BaseballGame {

    private int ball;
    private int strike;

    private void countStrikeAndBall(int[] ExpectedAnswer, int[] Answer) {
        resetBallAndStrike();
        for (int expectedAnswerIndex  =0 ; expectedAnswerIndex < ExpectedAnswer.length;expectedAnswerIndex++) {

            int expectedAnswerTarget=ExpectedAnswer[expectedAnswerIndex];
            for (int AnswerIndex  =0 ; AnswerIndex < Answer.length;AnswerIndex++) {

                if (expectedAnswerTarget == Answer[AnswerIndex]) {
                    if(expectedAnswerIndex==AnswerIndex){
                        strike++;
                    }
                    else{
                        ball++;
                    }
                }
            }
        }
    }

    private void resetBallAndStrike() {
        this.ball = 0;
        this.strike = 0;
    }
}
