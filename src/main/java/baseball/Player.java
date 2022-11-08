package baseball;

import baseball.Util.CountResult;
import baseball.Util.GameResultHandler;
import baseball.Util.RandomNumberGenerator;
import baseball.Util.InputHandler;

import java.util.List;
import java.util.Objects;

public class Player {
    private List<Integer> computerNumber;
    private static final String inputIndicator = "숫자를 입력해주세요 : ";

    public GameState gameState = GameState.GAME_STATE;

    public Player() {
        this.computerNumber = RandomNumberGenerator.generateNumbers();
//        System.out.println(computerNumber);
    }

    public List<Integer> getInput() {
        return InputHandler.getUserInput();
    }

    public GameState game() {
        GameResultHandler gameResultHandler = new GameResultHandler();
        System.out.println(inputIndicator);
        List<Integer> userThrow = getInput();
        return gameResultHandler.out(getResult(userThrow, computerNumber));
    }

    private CountResult getResult(List<Integer> userNumber, List<Integer> computerNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (Objects.equals(userNumber.get(i), computerNumber.get(i))) {
                strikeCount++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ballCount++;
            }
        }
        return new CountResult(strikeCount, ballCount);
    }
}
