package baseball.Input;

import camp.nextstep.edu.missionutils.Console;

public class InputManager implements InputManageable{

    @Override
    public String readInputFromUser() {
        return Console.readLine();
    }
}
