package baseball.view;

import static baseball.Rendering.PUT;

import baseball.controller.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private String readLine;

    public InputView() {
        this.readLine = Console.readLine();
    }

    public String putReadLine() {
        System.out.println(PUT.render());
        new Validator(readLine);
        return readLine;
    }


}
