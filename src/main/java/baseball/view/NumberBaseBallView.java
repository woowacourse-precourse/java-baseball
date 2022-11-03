package baseball.view;

import baseball.model.Result;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static baseball.resources.GameConfig.*;
import static baseball.resources.Sentence.*;

public class NumberBaseBallView {
    public void start(){
        println(START);
    }

    public String askInputNumber(){
        print(ASK_INPUT);
        return Console.readLine();
    }

    public void printResult(Result result) {
        Map<String, Integer> count = result.getEachCount();
        if (result.hasBallAndStrike()) {
            printf(BALL_STRIKE, count.get(BALL_COUNT), count.get(STRIKE_COUNT));
            return;
        }
        if (result.hasBall()) {
            printf(BALL, count.get(BALL_COUNT));
            return;
        }
        if (result.hasStrike()) {
            printf(STRIKE, count.get(STRIKE_COUNT));
            return;
        }
        println(NOTHING);
    }

    public String askRestart() {
        println(ASK_RESTART);
        return Console.readLine();
    }
}
