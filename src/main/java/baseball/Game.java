package baseball;

import static constant.Constant.*;

public class Game {
    private final Computer computer;
    private final Player player;
    private int gameStatus;

    public Game() {
        computer = new Computer();
        player = new Player();
        gameStatus = ON_GOING;
    }

    public void start() {
        computer.generateValue();
        System.out.println(START_MESSAGE);
        while (gameStatus == ON_GOING) {
            player.setInputValue(Input.receiveInput());
            if (computer.isAnswer(player.getValue())) {
                gameStatus = GAME_OVER;
            }
        }
        if (Input.restartOrEnd().equals("1")) {
            gameStatus = ON_GOING;
            start();
        }
    }
}