package baseball.game;

import baseball.Computer;
import baseball.Validator;
import org.junit.jupiter.api.Test;


class ComputerTest {
    @Test
    void 랜덤_넘버_생성() {
        Computer computer = new Computer();
        String randomNumberString = computer.makeRandomNumberString();
        Validator.validateNumberString(randomNumberString);
    }
}