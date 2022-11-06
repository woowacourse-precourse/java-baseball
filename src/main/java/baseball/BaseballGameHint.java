package baseball;

import java.util.stream.IntStream;

public class BaseballGameHint {

    private final String Nothing_Message = "낫생";
    private final String BALL_Message = "볼";
    private final String STRIKE_Message = "스트라이크";
    private final String ANSWER_Message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private int ball;
    private int strike;

    public void getHint(int[] ExpectedAnswer, int[] Answer){
        countStrikeAndBall(ExpectedAnswer,Answer);
        printHint();
    }

    private void countStrikeAndBall(int[] ExpectedAnswer, int[] Answer) {
        resetBallAndStrike();
        for (int expectedAnswerIndex  =0 ; expectedAnswerIndex < ExpectedAnswer.length;expectedAnswerIndex++) {
            int expectedAnswerTarget=ExpectedAnswer[expectedAnswerIndex];
            int findIndex=IntStream.range(0, Answer.length)
                    .filter(i -> expectedAnswerTarget == Answer[i])
                    .findFirst()
                    .orElse(-1);
            ballAndStrikeCount(expectedAnswerIndex, findIndex);
        }
    }

    private void ballAndStrikeCount(int expectedAnswerIndex, int findIndex) {
        if (expectedAnswerIndex == findIndex) {
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
            System.out.println(ANSWER_Message);
            return true;
        }
        return false;
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
