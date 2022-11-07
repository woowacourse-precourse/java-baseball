package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Computer computer;
    private final Player player;
    private int gameStatus;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int ON_GOING = 1;
    private static final int GAME_OVER = 0;

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