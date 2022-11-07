package baseball.game;

import static baseball.constant.SystemValue.BALL_COUNT;
import static baseball.constant.SystemValue.CONTINUE_GAME;
import static baseball.constant.SystemValue.STRIKE_COUNT;

import baseball.constant.SystemMessage;
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
        do {
            List<Integer> playerBalls = getPlayerInput();
            resultMessage = getResultFromComputer(computerBalls, playerBalls, strikeAndBallCounts);
            System.out.println(resultMessage);
            initialStrikeAndBallCounts(strikeAndBallCounts);
        } while (!resultMessage.equals(SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER));
    }

    private void initialStrikeAndBallCounts(List<Integer> strikeAndBallCounts) {
        strikeAndBallCounts.set(STRIKE_COUNT, 0);
        strikeAndBallCounts.set(BALL_COUNT, 0);
    }

    private String getResultFromComputer(List<Integer> computerBalls, List<Integer> playerBalls,
            List<Integer> strikeAndBallCounts) {
        computer.calculateStrikeAndBallCounts(computerBalls, playerBalls, strikeAndBallCounts);
        return computer.getResultMessage(strikeAndBallCounts.get(STRIKE_COUNT),
                strikeAndBallCounts.get(BALL_COUNT));
    }

    private List<Integer> getPlayerInput() {
        System.out.print(SystemMessage.ENTER_NUMBER);
        return player.getPlayerBalls();
    }
}
