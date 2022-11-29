package baseball.view;

import static baseball.Rendering.PUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String putReadLine() {
        System.out.println(PUT.print());
        return Console.readLine();
    }

}
