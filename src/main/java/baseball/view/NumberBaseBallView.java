package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.resources.Sentence.*;

public class NumberBaseBallView {
    public void start(){
        print(START);
    }

    public String askInputNumber(){
        print(ASK_INPUT);
        return Console.readLine();
    }
}
