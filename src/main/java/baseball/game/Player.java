package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String inputNumber;

    public void setInputNumber() {
        this.inputNumber = Console.readLine().trim();
    }

    public String getInputNumber() {
        return inputNumber;
    }
}
