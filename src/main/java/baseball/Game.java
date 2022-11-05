package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer;
    private final Player player;
    private int gameStatus;
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final int ON_GOING = 1;
    private final int GAME_OVER = 2;

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
            if (computer.isAnswer(player.getValue()) && restartOrEnd() == "1") {
                gameStatus = GAME_OVER;
                start();
            }
        }
    }

    private String receiveInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        Validation.checkInput(input);
        return input;
    }

    private String restartOrEnd() {
        System.out.println(RESTART_OR_END_MESSAGE);
        String input = Console.readLine();
        Validation.isRestartOrEnd(input);
        return input;
    }
}