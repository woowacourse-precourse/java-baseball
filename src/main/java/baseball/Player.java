package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private Baseballs input;

    public Player() {
    }

    public void typeAnswerByConsole() {
        this.input = Baseballs.of(Console.readLine());
    }
}
