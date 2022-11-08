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
    private final Output output;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
        this.output = new Output();
    }

    public void startGame() {
        output.printWelcomeMessage();
        do {
            playGame();
            output.printRestartMessage();
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
        output.printResultMessage(resultMessage);
        return resultMessage;
    }

    private List<Integer> playerTurn() {
        output.printEnterNumberMessage();
        return player.getPlayerBalls();
    }
}
