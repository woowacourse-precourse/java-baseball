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


    public int getStrike() {
        return strike;
    }
    public int getBall() {
        return ball;
    }
    public boolean getStatus() {
        return status;
    }
    public LinkedHashSet<Character> getCorrectNum() {
        return correctNum;
    }


    public void makeRandomNum3() {
        for(int i = 0; i < 3; i++){
            appendRandomNum(makeRandomNum());
        }
    }

    public void appendRandomNum(char c) {
        correctNum.add(c);
    }

    public char makeRandomNum() {
        char randomNumber;
        do {
            randomNumber = (char) (Randoms.pickNumberInRange(1, 9) + '0');
        } while (correctNum.contains(randomNumber));

        return randomNumber;
    }

    public void resetNum() {
        correctNum.clear();
    }

    public void submitNum(LinkedHashSet<Character> inputNum) {
        strike = bc.strikeJudgement(getCorrectNum(), inputNum);
        ball = bc.ballJudgement(getCorrectNum(), inputNum);
    }

    public void isCorrected() throws IOException {
        if(getStrike() == 3) {
            printGameEnd();
            isRestartGame();
        }
    }

    public void runGame() throws IOException {
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

    public void isRestartGame() {
        if("2".equals(inputEnd())) {
            status = false;

        } else {
            resetNum();
            makeRandomNum3();

        }
    }
}
