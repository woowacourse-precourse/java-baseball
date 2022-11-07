package baseball.game;

import static baseball.game.Computer.BALL_COUNT;
import static baseball.game.Computer.STRIKE_COUNT;
import static baseball.util.InputValidator.CONTINUE_GAME;

import baseball.message.SystemMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final Computer computer;
    private final Player player;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
    }

    public void startGame() {
        System.out.println(SystemMessage.START_NUMBER_BASEBALL_GAME);
        do {
            playGame();
            System.out.println(SystemMessage.RESTART_GAME_OR_END);
        } while (Integer.parseInt(player.getPlayerAnswer()) == CONTINUE_GAME);
    }

    public void playGame() {
        List<Integer> computerBalls = computer.getComputerBalls();
        List<Integer> strikeAndBallCounts = new ArrayList<>(Arrays.asList(0, 0));
        String resultMessage;
        System.out.println(computerBalls.toString()); // TODO: 삭제하기
        do {
            System.out.print(SystemMessage.ENTER_NUMBER);
            List<Integer> playerBalls = player.getPlayerBalls();
            computer.calculateStrikeAndBallCounts(computerBalls, playerBalls, strikeAndBallCounts);
            resultMessage = computer.getResultMessage(strikeAndBallCounts.get(STRIKE_COUNT),
                    strikeAndBallCounts.get(BALL_COUNT));
            System.out.println(resultMessage);
            computer.updateStrikeAndBallCounts(strikeAndBallCounts, 0, 0);
        } while (!resultMessage.equals(SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER));
    }
}
