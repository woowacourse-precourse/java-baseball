package baseball.game;

import static baseball.constant.SystemMessage.THREE_NUMBERS_RIGHT_GAME_OVER;
import static baseball.constant.SystemValue.BALL_COUNT;
import static baseball.constant.SystemValue.CONTINUE_GAME;
import static baseball.constant.SystemValue.STRIKE_COUNT;

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
        String hint;
        do {
            playerBalls = playerTurn();
            hint = computerTurn(computerBalls, playerBalls, strikeAndBallResults);
            initializeStrikeAndBallResults(strikeAndBallResults);
        } while (!isGameOver(hint));
    }

    private boolean isContinue() {
        return Integer.parseInt(player.getPlayerAnswer()) == CONTINUE_GAME;
    }

    private boolean isGameOver(String hint) {
        return hint.equals(THREE_NUMBERS_RIGHT_GAME_OVER);
    }

    private void initializeStrikeAndBallResults(List<Integer> strikeAndBallResults) {
        strikeAndBallResults.set(STRIKE_COUNT, 0);
        strikeAndBallResults.set(BALL_COUNT, 0);
    }

    private String computerTurn(List<Integer> computerBalls, List<Integer> playerBalls,
            List<Integer> strikeAndBallResults) {
        String hint;
        computer.countStrikeAndBallResults(computerBalls, playerBalls, strikeAndBallResults);
        hint = computer.getHint(strikeAndBallResults.get(STRIKE_COUNT),
                strikeAndBallResults.get(BALL_COUNT));
        computer.printHint(hint);
        return hint;
    }

    private List<Integer> playerTurn() {
        output.printEnterNumberMessage();
        return player.getPlayerBalls();
    }
}
