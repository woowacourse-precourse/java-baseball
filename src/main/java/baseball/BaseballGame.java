package baseball;

import java.io.IOException;
import java.util.LinkedHashSet;
import baseball.calculate.BaseballCalculator;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.inputoutput.Inputting.*;
import static baseball.inputoutput.Outputting.*;

public class BaseballGame {

    private final BaseballCalculator bc = new BaseballCalculator();
    private final LinkedHashSet<Character> correctNum = new LinkedHashSet<>(3);
    private int strike = 0;
    private int ball = 0;
    private boolean status = false;


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


    protected void makeRandomNum3() {
        for(int i = 0; i < 3; i++){
            putRandomNum(makeRandomNum());
        }
    }

    protected void putRandomNum(char c) {
        correctNum.add(c);
    }

    protected char makeRandomNum() {
        char randomNumber;
        do {
            randomNumber = (char) (Randoms.pickNumberInRange(1, 9) + '0');
        } while (correctNum.contains(randomNumber));

        return randomNumber;
    }

    protected void resetNum() {
        correctNum.clear();
    }

    protected void submitNum(LinkedHashSet<Character> inputNum) {
        strike = bc.strikeJudgement(getCorrectNum(), inputNum);
        ball = bc.ballJudgement(getCorrectNum(), inputNum);
    }

    protected void isCorrected() throws IOException {
        if(getStrike() == 3) {
            printGameEnd();
            isRestartGame();
        }
    }

    protected void runGame() throws IOException {
        makeRandomNum3();
        status = true;

        printGameStart();

        while (getStatus()) {

            submitNum(input3LenNumber());
            writeCase(getStrike(), getBall());

            printLine();
            isCorrected();
        }
    }

    protected void isRestartGame() {
        if("2".equals(inputEnd())) {
            status = false;

        } else {
            resetNum();
            makeRandomNum3();

        }
    }
}
