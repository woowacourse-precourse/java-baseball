package baseball;

import java.io.IOException;
import java.util.LinkedHashSet;
import baseball.calculate.BaseballCalculator;

import static baseball.inputoutput.Inputing.*;
import static baseball.inputoutput.Outputing.*;



public class Application {

    private static BaseballCalculator bc = new BaseballCalculator();

    public static void main(String[] args) throws IOException {

        BaseballGame bg = new BaseballGame();

        LinkedHashSet<Character> inputNum;
        printGameStart();

        while (bg.getStatus()) {
            inputNum = input3LenNumber();

            bg.setStrike(bc.strikeJudge(bg.getCorrectNum(), inputNum));
            bg.setBall(bc.ballJudge(bg.getCorrectNum(), inputNum));

            writeCase(bg.getStrike(), bg.getBall());
            printLine();

            if (bg.getStrike() == 3) {
                printGameEnd();

                if ("2".equals(inputEnd())){
                    bg.endGame();
                } else {
                    bg.resetNum();
                    bg.makeRandomNum();
                }
            }
        }

        exitOutput();
    }
}
