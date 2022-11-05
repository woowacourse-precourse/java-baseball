package baseball;

import baseball.Input.InputAndVerification;

import java.util.List;

import static baseball.CountStrikeOrBall.getBallNumber;
import static baseball.CountStrikeOrBall.getStrikeNumber;
import static baseball.print.OutputStatement.*;

public class ProgressGame {
    InputAndVerification inputAndVerification = new InputAndVerification();

    AnswerNumber answerNumber = new AnswerNumber();

    public void progress(){

        List<Integer>answerNumberList = answerNumber.makeAnswerNumber();
        progressGame(answerNumberList);


        if(progressAfterCorrectAnswer() ==1){
            progress();
        }

    }

    private void progressGame(List<Integer> answerNumberList){

        int strikeCnt = 0;
        int ballCnt = 0;
        int receivedNumber = 0;

        requestNumberInput();
        receivedNumber += inputAndVerification.receiveAndVerifyNumber();

        strikeCnt += getStrikeNumber(answerNumberList, receivedNumber);
        ballCnt += getBallNumber(answerNumberList, receivedNumber);

        hint(ballCnt, strikeCnt);
        if(strikeCnt != 3){
            progressGame(answerNumberList);
        }
    }

    private int progressAfterCorrectAnswer(){
        informResultAnswer();
        askGameRestartOrFinish();
        int receiveGameEndOneOrTwo =  inputAndVerification.receiveAfterGameEndOneOrTwo();

        return receiveGameEndOneOrTwo;
    }
}
