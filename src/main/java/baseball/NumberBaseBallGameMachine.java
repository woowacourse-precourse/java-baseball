package baseball;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseBallGameMachine {
    public void display(String message) {
        System.out.print(message);
    }

    public String getInputLine() {
        return Console.readLine();
    }
}
