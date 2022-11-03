package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.view.Display.*;

public class Controller {
    public void printRoundStart() {
        printInitMessage();
    }

    public String printAndInputNumber() {
        printInputNumberMessage();
        String input = Console.readLine();
        // TODO input 유효성 검증 코드 작성
        return input;
    }

}
