package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Score;
import baseball.utils.Parser;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.vo.GameInterfaceMsg.*;

public class BaseballGameService {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int RESULT_COUNT = 3;
    private static final int RESTART_NUMBER = 1;

    Computer computer;
    Player player;
    Score score;
    Parser parser = new Parser();

    public void setComputer() {
        System.out.println(GAME_START.getMessage());
        computer = new Computer(START_INCLUSIVE, END_INCLUSIVE, RESULT_COUNT);
    }

    private void setPlayer() {
        String playerInput = Console.readLine();
        player = new Player(parser.parsePlayerNumbers(playerInput));
    }

    private void play() {
        System.out.print(REQUEST_INPUT.getMessage());
        setPlayer();
        computeScore(computer.getResult(), player.getPlayerNumbers());
    }

    public boolean isRestart() {
        System.out.println(GAME_RESTART_END.getMessage());
        int input = parser.parseInt(Console.readLine());
        return input == RESTART_NUMBER;
    }

    private void computeScore(List<Integer> result, List<Integer> playerNumbers) {
        for (int i = 0; i < RESULT_COUNT; i++) {
            if (result.get(i).equals(playerNumbers.get(i))) {
                score.increaseStrike();
            }

            else if (result.contains(playerNumbers.get(i))) {
                score.increaseBall();
            }
        }

        System.out.println(score);
    }
}
