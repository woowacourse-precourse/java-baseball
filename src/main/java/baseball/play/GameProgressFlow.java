package baseball.play;

import baseball.Input.InputAndVerification;
import baseball.answer.AnswerRandomNumber;
import baseball.count.CountStrikeOrBall;

import java.util.List;

import static baseball.print.OutputStatement.*;

public class GameProgressFlow {
    InputAndVerification inputAndVerification = new InputAndVerification();
    AnswerRandomNumber answerRandomNumber = new AnswerRandomNumber();

    public void startGame() {

        List<Integer> answerNumberList = answerRandomNumber.makeAnswerRandomNumber();
        RepeatTheBaseballGame(answerNumberList);

        if (askBaseballGameRestartAndFinish() == 1) {
            startGame();
        }

    }

    private void RepeatTheBaseballGame(List<Integer> answerNumberList) {
        CountStrikeOrBall countStrikeOrBall = new CountStrikeOrBall();

        int strikeCnt = 0;
        int ballCnt = 0;

        requestNumberInput();
        int receivedNumber = inputAndVerification.receiveAndVerifyNumber();

        strikeCnt += countStrikeOrBall.getStrikeNumber(answerNumberList, receivedNumber);
        ballCnt += countStrikeOrBall.getBallNumber(answerNumberList, receivedNumber);

        printHint(ballCnt, strikeCnt);
        if (strikeCnt != 3) {
            RepeatTheBaseballGame(answerNumberList);
        }
    }

    private int askBaseballGameRestartAndFinish() {
        informResultAnswerAndFinish();
        askGameRestartOrFinish();

        return inputAndVerification.receiveAfterGameEndOneOrTwo();
    }
}
