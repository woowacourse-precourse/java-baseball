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

    public void getUserNumbers(){
        inputUtil.inputUserNumbers();
    }
}
