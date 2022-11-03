package baseball.game;

import baseball.number.ComputerNumber;
import baseball.number.NumberDto;

import static baseball.util.Constant.GAME_START_MESSAGE;

public class Game {
    NumberDto computerNumber;

    public Game() {}

    private void initiate() {
        System.out.println(GAME_START_MESSAGE);
        computerNumber = ComputerNumber.generate();
    }

    public void play() {
        initiate();
    }
}
