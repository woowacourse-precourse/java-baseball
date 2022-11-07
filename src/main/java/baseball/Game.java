package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final Computer computer;
    private final Player player;
    private int gameStatus;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
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
            player.setInputValue(receiveInput());
            if (computer.isAnswer(player.getValue())) {
                gameStatus = GAME_OVER;
            }
        }
        if (restartOrEnd().equals("1")) {
            gameStatus = ON_GOING;
            start();
        }
    }

    private String receiveInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        Validation.checkInput(input);
        return input;
    }

    private static String restartOrEnd() {
        System.out.println(RESTART_OR_END_MESSAGE);
        String input = Console.readLine();
        Validation.isRestartOrEnd(input);
        return input;
    }
}