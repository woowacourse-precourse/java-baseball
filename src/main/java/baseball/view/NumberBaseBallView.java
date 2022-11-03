package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static baseball.resources.Sentence.*;

public class NumberBaseBallView {
    public void start(){
        print(START);
    }

    public String askInputNumber(){
        print(ASK_INPUT);
        return Console.readLine();
    }

    public void printResult(Map<String, Integer> result) {
        print(result);
    }

    public String askRestart() {
        print(ASK_RESTART);
        return Console.readLine();
    }
}
