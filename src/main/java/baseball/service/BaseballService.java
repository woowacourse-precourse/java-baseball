package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.Constant;
import baseball.utils.InputUtil;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class BaseballService {
    private final User user;
    private final Computer computer;
    private final Game game;
    private final InputUtil inputUtil;

    public BaseballService() {
        user = new User();
        computer = new Computer();
        game = new Game();
        inputUtil = new InputUtil();
    }

    public boolean getGameStatus() {
        return game.getStatus();
    }

    public void createRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!checkDuplication(randomNumbers, number)) {
                randomNumbers.add(number);
            }
        }
    }

    public boolean checkDuplication(ArrayList<Integer> randomNumbers, int number) {
        return randomNumbers.contains(number);
    }

    public void getUserNumbers() {
        user.setUserNumbers(inputUtil.inputUserNumbers());
    }

    public void outputHint() {
        ArrayList<Integer> userNumbers = user.getUserNumbers();
        ArrayList<Integer> computerNumbers = computer.getRandomNumbers();

        game.setBall(0);
        game.setStrike(0);
        for (int i = 0; i < computer.getRandomNumbers().size(); i++) {
            game.setStrike(game.getStrike() + isStrike(computerNumbers.get(i), userNumbers.get(i));
            game.setBall(game.getBall() + isBall(computerNumbers, userNumbers.get(i), i));
        }
        System.out.println(createOutput(game.getStrike(), game.getBall()));
    }

    public int isStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            return 1;
        }
        return 0;
    }

    public int isBall(ArrayList<Integer> computer, int userNumber, int index) {
        if (computer.get(index) != userNumber && computer.contains(userNumber)) {
            return 1;
        }
        return 0;
    }

    public String createOutput(int strike, int ball) {
        if (strike == Constant.IS_ANSWER.getNumber()) {
            return strike + Constant.STRIKE.getMessage();
        } else if (strike != Constant.IS_NONE.getNumber() && ball != Constant.IS_NONE.getNumber()) {
            return ball + Constant.BALL.getMessage() + " " + strike + Constant.STRIKE.getMessage();
        } else if (strike > Constant.IS_NONE.getNumber()) {
            return strike + Constant.STRIKE.getMessage();
        } else if (ball > Constant.IS_NONE.getNumber()) {
            return ball + Constant.BALL.getMessage();
        } else {
            return Constant.NOTHING.getMessage();
        }
    }
}
