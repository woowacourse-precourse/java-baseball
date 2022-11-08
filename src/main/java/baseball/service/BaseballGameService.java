package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.utils.Parser;
import camp.nextstep.edu.missionutils.Console;

import static baseball.vo.GameInterfaceMsg.GAME_START;

public class BaseballGameService {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int RESULT_COUNT = 3;

    Computer computer;
    Player player;
    Parser parser = new Parser();

    public void setComputer() {
        System.out.println(GAME_START.getMessage());
        computer = new Computer(START_INCLUSIVE, END_INCLUSIVE, RESULT_COUNT);
    }

    private void setPlayer() {
        String playerInput = Console.readLine();
        player = new Player(parser.parsePlayerNumbers(playerInput));
    }
}
