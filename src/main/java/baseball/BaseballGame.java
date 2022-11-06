package baseball;

public class BaseballGame {

    private final String Nothing_Message = "낫생";
    private final String BALL_Message = "볼";
    private final String STRIKE_Message = "스트라이크";
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

    private void printHint() {
        if (ball == 0 && strike == 0) {
            System.out.println(Nothing_Message);
        }else if(ball > 0 && strike > 0){
            System.out.println(ball+BALL_Message+" "+strike+STRIKE_Message);
        }else if(ball > 0){
            System.out.println(ball+BALL_Message);
        }else if(strike > 0){
            System.out.println(strike+STRIKE_Message);
        }
    }
}
