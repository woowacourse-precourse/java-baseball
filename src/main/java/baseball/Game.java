package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer;
    private final Player player;
    private final Referee referee;
    private int gameStatus;
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final int ON_GOING = 1;
    private final int GAME_OVER = 2;

    public Game() {
        computer = new Computer();
        player = new Player();
        referee = new Referee();
        gameStatus = ON_GOING;
    }

    public void start() {
        computer.generateValue();
        System.out.println(START_MESSAGE);
        while (gameStatus == ON_GOING) {
            player.setInputValue(receiveInput());
            // TODO: referee
        }
    }

    private String receiveInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        Validation.checkInput(input);
        return input;
    }
}
