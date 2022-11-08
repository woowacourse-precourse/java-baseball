package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class BaseballGame {

    private final Balls balls;
    private boolean playing;
    private static final String GAME_CONTINUE_COMMAND = "1";
    private static final String GAME_FINISH_COMMAND = "2";
    private static final String ballPattern = "^\\d{3}$";

    public BaseballGame() {
        balls = new Balls();
        playing = true;
    }

    public BaseballGame(List<Integer> balls) {
        this.balls = new Balls(balls);
        playing = true;
    }

    public GameBoard playGame(String selectedBallNumbers) {
        validateNumbers(selectedBallNumbers);
        return compareNumbers(selectedBallNumbers);
    }

    private void validateNumbers(String selectedBallNumbers) {
        if (!Pattern.matches(ballPattern, selectedBallNumbers)) {
            throw new IllegalArgumentException("3개의 숫자를 선택해야 합니다.");
        }

        Set<Character> numbers = new HashSet<>();
        for (char c : selectedBallNumbers.toCharArray()) {
            if (!numbers.add(c)) {
                throw new IllegalArgumentException("서로 다른 3개의 숫자를 선택해야 합니다.");
            }
        }
    }

    private GameBoard compareNumbers(String selectedBallNumbers) {
        GameBoard gameBoard = new GameBoard();
        for (int i = 0; i < 3; i++) {
            int num = selectedBallNumbers.charAt(i) - '0';
            compareNumber(gameBoard, i, num);
        }
        return gameBoard;
    }

    private void compareNumber(GameBoard gameBoard, int i, int num) {
        if (balls.isStrike(i, num)) {
            gameBoard.strike();
            return;
        }
        if (balls.isBall(i, num)) {
            gameBoard.ball();
        }
    }

    public void checkContinueCommand(String command) {
        if (command.equals(GAME_FINISH_COMMAND)) {
            playing = false;
        }
        if (command.equals(GAME_CONTINUE_COMMAND)) {
            balls.initBalls();
        }
    }

    public boolean isPlaying() {
        return playing;
    }
}
