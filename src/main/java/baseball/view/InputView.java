package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constValue.Constants.InputMessage.*;

public class InputView {

    public String restart(){
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public String playerInput(){
        System.out.print(INPUT_MESSAGE);
        String input=Console.readLine();
        return input;
    }
}
