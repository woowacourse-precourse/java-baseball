package baseball.game.service;

import baseball.game.domain.Computer;
import baseball.utils.InputValidator;
import baseball.utils.RandomUtils;

public class GameService {
    private Computer computer;

    public GameService() {
        computer = new Computer();
    }

    public void computeComputerNumbers() {
        computer.setNumberList(RandomUtils.getRandomNumberList());
    }

    public void verifyNumberOfInput(String numbers) {
        if (!InputValidator.isValidNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

}
