package baseball;

import java.io.IOException;
import java.util.LinkedHashSet;
import camp.nextstep.edu.missionutils.Randoms;
import baseball.calculate.BaseballCalculator;

import static baseball.inputoutput.Inputting.*;
import static baseball.inputoutput.Outputting.*;

public class BaseballGame {

    private static BaseballCalculator bc = new BaseballCalculator();
    private LinkedHashSet<Character> correctNum = new LinkedHashSet<>(3);
    private int strike = 0;
    private int ball = 0;
    private boolean status = false;


    BaseballGame() throws IOException{

        makeRandomNum();
        setStatus(true);

        printGameStart();

        while (getStatus()) {

            submitNum(input3LenNumber());
            writeCase(getStrike(), getBall());

            printLine();
            isCorrected();
        }
    }


    protected int getStrike() {
        return strike;
    }
    protected int getBall() {
        return ball;
    }
    protected boolean getStatus() {
        return status;
    }
    protected LinkedHashSet<Character> getCorrectNum() {
        return correctNum;
    }
    protected void setStrike(int n) {
        strike = n;
    }
    protected void setBall(int n) {
        ball = n;
    }
    protected void setStatus(boolean b) {
        status = b;
    }

    protected void makeRandomNum() {
        while (correctNum.size() < 3) {
            char randomNumber = (char) (Randoms.pickNumberInRange(1, 9) + '0');
            correctNum.add(randomNumber);
        }
    }

    protected void resetNum() {

        correctNum.clear();
    }

    protected void submitNum(LinkedHashSet<Character> inputNum) {

        setStrike(bc.strikeJudge(getCorrectNum(), inputNum));
        setBall(bc.ballJudge(getCorrectNum(), inputNum));
    }

    protected void isCorrected() throws IOException {

        if(getStrike() == 3) {
            printGameEnd();

            isRestartGame();
        }
    }

    protected void isRestartGame() throws IOException {
        if("2".equals(inputEnd())) {
            setStatus(false);
            exitOutput();
        } else {
            resetNum();
            makeRandomNum();
        }
    }
}
