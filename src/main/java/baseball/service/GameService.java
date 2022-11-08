package baseball.service;

import static baseball.domain.User.getUserInputNumberList;

import baseball.domain.Computer;
import baseball.domain.Constant;
import baseball.domain.User;
import baseball.view.OutputView;
import java.util.List;

public class GameService {
    private int strike;
    private int ball;

    User user = new User();
    Computer computer = new Computer();
    OutputView outputView = new OutputView();

    public void startNumberBaseballGame() {
        List<Integer> computerRandomNumberList = getComputerRandomNumbers();
        strike = Constant.STRIKE_DEFAULT;
        while (strike != Constant.THREE_STRIKE_NUMBER) {
            initNumberStrikeAndBallCount();
            List<Integer> userNumberList = getUserInputNumbers();
            setSumOfStrikeCountAndBallCount(computerRandomNumberList, userNumberList);
            outputView.printNumberBaseballResult(getBallCount(), getStrikeCount());

        }

    }

    public void initNumberStrikeAndBallCount() {
        strike = Constant.STRIKE_DEFAULT;
        ball = Constant.BALL_DEFAULT;
    }

    public List<Integer> getComputerRandomNumbers() {
        computer.setComputerRandomNumberList();
        List<Integer> computerRandomNumberList = computer.getComputerRandomNumberList();
        return computerRandomNumberList;
    }

    public List<Integer> getUserInputNumbers() {

        user.setUserInputNumberList();
        List<Integer> users = getUserInputNumberList();
        return users;
    }

    public void setSumOfStrikeCountAndBallCount(List<Integer> computerNumberList, List<Integer> userNumberList) {
        countStrike(computerNumberList, userNumberList);
        countBall(computerNumberList, userNumberList);
    }

    public void countStrike(List<Integer> computerNumberList, List<Integer> userNumberList) {
        for (int i = 0; i < Constant.MAX_NUMBER_SIZE; i++) {
            if ((computerNumberList.get(i) == userNumberList.get(i))) {
                addStrikeCount();
            }
        }
    }

    public void countBall(List<Integer> computerNumberList, List<Integer> userNumberList) {
        for (int i = 0; i < Constant.MAX_NUMBER_SIZE; i++) {
            if (computerNumberList.contains(userNumberList.get(i)) && !computerNumberList.get(i)
                    .equals(userNumberList.get(i))) {
                addBallCount();
            }
        }
    }

    public int getStrikeCount() {
        return strike;
    }

    public int getBallCount() {
        return ball;
    }

    public void addStrikeCount() {
        strike += 1;
    }

    public void addBallCount() {
        ball += 1;
    }



}

