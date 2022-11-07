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
        System.out.println(computerRandomNumberList);
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
        List<Integer> computerRandomNumberList =computer.getComputerRandomNumberList();
        return computerRandomNumberList;
    }


}

