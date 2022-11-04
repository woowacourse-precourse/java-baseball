package baseball.view;

import baseball.model.Result;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static baseball.resources.GameConfig.*;
import static baseball.resources.Sentence.*;

public class NumberBaseBallView {
    public void start(){
        System.out.println(START);
    }

    public String askInputNumber(){
        System.out.print(ASK_INPUT);
        return Console.readLine();
    }

    public void printResult(Result result) {
        Map<String, Integer> count = result.getEachCount();
        if (result.hasBallAndStrike()) {
            System.out.printf(BALL_STRIKE, count.get(BALL_COUNT), count.get(STRIKE_COUNT));
            return;
        }
        if (result.hasBall()) {
            System.out.printf(BALL, count.get(BALL_COUNT));
            return;
        }
        if (result.hasStrike()) {
            System.out.printf(STRIKE, count.get(STRIKE_COUNT));
            return;
        }
        System.out.println(NOTHING);
    }

    public String askRestart() {
        System.out.println(ASK_RESTART);
        return Console.readLine();
    }
}
