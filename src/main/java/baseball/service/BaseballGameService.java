package baseball.service;


import baseball.domain.Computer;
import baseball.domain.User;
import baseball.exception.InputUserNumberException;
import baseball.view.BaseballGameView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {
    private static int strikeCount;
    private static int ballCount;
    private InputUserNumberException inputUserNumberException = new InputUserNumberException();

    private final int NUMBER_LENGTH = 3;

    private BaseballGameView baseballGameView = new BaseballGameView();

    private User user = new User();

    private Computer computer = new Computer();

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

    public void setUserNumber() {
        String userNumber = baseballGameView.inputNumber();
        inputUserNumberException.findUserNumberException(userNumber);
        List<Integer> userNumberList = new ArrayList<>();
        for (int index = 0; index < userNumber.length(); index++) {
            userNumberList.add(userNumber.charAt(index) - '0');
        }
        user.setSelectNumber(userNumberList);
    }


    public List<Integer> getUserNumber() {
        return user.getSelectNumber();
    }

    public void setComputerNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        computer.setRandomNumber(randomNumbers);
    }
}


