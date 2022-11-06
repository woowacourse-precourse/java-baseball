package baseball.game.service;

import baseball.game.domain.Computer;
import baseball.game.domain.User;
import baseball.utils.InputValidator;
import baseball.utils.NumberUtil;

public class GameService {
    private Computer computer;
    private User user;

    public GameService() {
        computer = new Computer();
        user = new User();
    }

    public void computeComputerNumbers() {
        computer.setNumberList(NumberUtil.getRandomNumberList());
    }

    public void setUserNumbers(String numbers) {
        if (!InputValidator.isValidNumbers(numbers)) {
            throw new IllegalArgumentException();
        }

       user.setNumberList(NumberUtil.getNumberList(numbers));
    }

}
