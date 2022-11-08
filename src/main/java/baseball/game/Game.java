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
        } while (isContinue());
    }

    public void playGame() {
        List<Integer> playerBalls;
        List<Integer> computerBalls = computer.getComputerBalls();
        List<Integer> strikeAndBallResults = new ArrayList<>(Arrays.asList(0, 0));
        String resultMessage;
        do {
            playerBalls = playerTurn();
            resultMessage = computerTurn(computerBalls, playerBalls, strikeAndBallResults);
            initializeStrikeAndBallResults(strikeAndBallResults);
        } while (!isGameOver(resultMessage));
    }

    private boolean isContinue() {
        return Integer.parseInt(player.getPlayerAnswer()) == CONTINUE_GAME;
    }

    private boolean isGameOver(String resultMessage) {
        return resultMessage.equals(SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER);
    }

    private void initializeStrikeAndBallResults(List<Integer> strikeAndBallResults) {
        strikeAndBallResults.set(STRIKE_COUNT, 0);
        strikeAndBallResults.set(BALL_COUNT, 0);
    }

    private String computerTurn(List<Integer> computerBalls, List<Integer> playerBalls,
            List<Integer> strikeAndBallResults) {
        String resultMessage;
        computer.countStrikeAndBallResults(computerBalls, playerBalls, strikeAndBallResults);
        resultMessage = computer.getResultMessage(strikeAndBallResults.get(STRIKE_COUNT),
                strikeAndBallResults.get(BALL_COUNT));
        System.out.println(resultMessage);
        return resultMessage;
    }

    private List<Integer> playerTurn() {
        System.out.print(SystemMessage.ENTER_NUMBER);
        return player.getPlayerBalls();
    }
}
