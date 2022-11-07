package baseball.service;


import baseball.domain.User;
import baseball.exception.InputUserNumberException;
import baseball.view.BaseballGameView;
import java.util.List;

public class BaseballGameService {
    private static int strikeCount;
    private static int ballCount;
    private InputUserNumberException inputUserNumberException = new InputUserNumberException();

    private final int NUMBER_LENGTH = 3;

    private BaseballGameView baseballGameView = new BaseballGameView();

    private User user;

    public void updateStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        strikeCount = 0;
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (computerNumber.get(index).equals(userNumber.get(index))) {
                strikeCount++;
            }
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }


    public void updateBallCount(List<Integer> computerNumber, List<Integer> userNumber) {
        ballCount = 0;
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (computerNumber.contains(userNumber.get(index)) &&
                    !computerNumber.get(index).equals(userNumber.get(index))) {
                ballCount++;
            }
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public String choiceRestartGame() {
        String choiceRestartNumber = baseballGameView.inputNumber();
        inputUserNumberException.checkInputRestartNumber(choiceRestartNumber);
        return choiceRestartNumber;
    }

    public void initStrikeCountAndBallCount() {
        strikeCount = 0;
        ballCount = 0;
    }
    public void setUserNumber(){
        user = new User();
        String userNumber = baseballGameView.inputNumber();
        inputUserNumberException.findUserNumberException(userNumber);
        user.setSelectNumber(userNumber);
    }
}


