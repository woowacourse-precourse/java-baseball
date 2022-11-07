package baseball;

import java.util.stream.IntStream;
import static baseball.Const.*;

public class BaseballGameHint {

    private int ball;
    private int strike;

    public void getHint(int[] ExpectedAnswer, int[] Answer){
        countStrikeAndBall(ExpectedAnswer,Answer);
        printHint();
    }

    private void countStrikeAndBall(int[] userInput, int[] Answer) {
        resetBallAndStrike();
        for (int userInputIndex  =0 ;userInputIndex < userInput.length;userInputIndex++) {
            int expectedAnswerTarget=userInput[userInputIndex];
            int findIndex=IntStream.range(0, Answer.length)
                    .filter(i -> expectedAnswerTarget == Answer[i])
                    .findFirst()
                    .orElse(-1);
            ballAndStrikeCount(userInputIndex, findIndex);
        }
    }

    private void ballAndStrikeCount(int userInputIndex, int findIndex) {
        if (userInputIndex == findIndex) {
            strike++;
        } else if (findIndex > -1) {
            ball++;
        }
    }

    private void resetBallAndStrike() {
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

    //스위치로 바구기
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
