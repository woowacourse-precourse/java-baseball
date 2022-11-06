package baseball;

import java.util.Arrays;

public class BaseballGame {

    private final String Nothing_Message = "낫생";
    private final String BALL_Message = "볼";
    private final String STRIKE_Message = "스트라이크";
    private final String ANSWER_Message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String START_Message = "숫자 야구 게임을 시작합니다.";
    private int ball;
    private int strike;
    private final UserInput userInput = new UserInput();
    private final AnswerGenerator answerGenerator= new AnswerGenerator();

    public void start() {
        System.out.println(START_Message);
        answerGenerator.generateAnswer();
        do{
            userInput.setNumberOfUser();
            countStrikeAndBall(userInput.getUserInput(), answerGenerator.getAnswer());
            printHint();
        }while(!isAnswer());

        String userChoice = userInput.inputRestartOrStop();
        if ("1".equals(userChoice)) {
            start();
        }
    }

    public boolean isAnswer() {
        if (strike == 3) {
            System.out.println(ANSWER_Message);
            return true;
        }
        return false;
    }

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
