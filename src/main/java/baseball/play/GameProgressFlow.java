package baseball.play;

import baseball.Input.InputAndVerification;

import java.util.List;

import static baseball.answer.AnswerRandomNumber.makeAnswerRandomNumber;
import static baseball.count.CountStrikeOrBall.getBallNumber;
import static baseball.count.CountStrikeOrBall.getStrikeNumber;
import static baseball.print.OutputStatement.*;

public class GameProgressFlow {
    InputAndVerification inputAndVerification = new InputAndVerification();

    public void startGame() {

        List<Integer> answerNumberList = makeAnswerRandomNumber();
        RepeatTheBaseballGame(answerNumberList);

        if (askBaseballGameRestartAndFinish() == 1) {
            startGame();
        }

    }

    private void RepeatTheBaseballGame(List<Integer> answerNumberList) {

        int strikeCnt = 0;
        int ballCnt = 0;

        requestNumberInput();
        int receivedNumber = inputAndVerification.receiveAndVerifyNumber();

        strikeCnt += getStrikeNumber(answerNumberList, receivedNumber);
        ballCnt += getBallNumber(answerNumberList, receivedNumber);

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
