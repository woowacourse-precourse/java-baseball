package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    private Computer computer;
    private Player player;
    private Judge judge;

    public BaseballGame() {
        initRandomNumber();
    }

    public void executeGame() {
        // player input 받고, 숫자 비교
    }

    private void initRandomNumber() {
        computer = new Computer();
    }

    private void playerInput() {
        String input = readLine();
        player = new Player(input);
    }
}
