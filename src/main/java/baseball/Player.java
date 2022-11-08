package baseball;

import baseball.Util.CountResult;
import baseball.Util.GameResultHandler;
import baseball.Util.RandomNumberGenerator;
import baseball.Util.InputHandler;

import java.util.List;

public class Player {
    private List<Integer> computerNumber;
    private static final String inputIndicator = "숫자를 입력해주세요 : ";

    public GameState gameState = GameState.GAME_STATE;

    public Player() {
        this.computerNumber = RandomNumberGenerator.generateNumbers();
        System.out.println(computerNumber);
    }

    public List<Integer> getInput() {
        return InputHandler.getUserInput();
    }

    public GameState game() {
        GameResultHandler gameResultHandler = new GameResultHandler();
        System.out.println(inputIndicator);
        List<Integer> userThrow = getInput();
        GameState state = gameResultHandler.out(getResult(userThrow, computerNumber));
        return state;
    }

    private CountResult getResult(List<Integer> userNumber, List<Integer> computerNumber) {
        CountResult count = new CountResult(strikeCount(userNumber, computerNumber), ballCount(userNumber, computerNumber));
        return count;
    }

    private int ballCount(List<Integer> userNumber, List<Integer> computerNumber) {
        int count = 0;
        for (int balls :
                userNumber) {
            if (computerNumber.contains(balls))
                count++;
        }
        return count;
    }

    private int strikeCount(List<Integer> userNumber, List<Integer> computerNumber) {
        int count = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if(userNumber.get(i) == computerNumber.get(i))
                count++;
        }
        return count;
    }


}
