package baseball.model;

import baseball.RandomUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class OpponentComputerTest {

    @Test
    void 상대방_생성과_동시에_랜덤_수_저장() {
        OpponentComputer opponentComputer = new OpponentComputer(RandomUtil.createRandomNumber());
        if (opponentComputer == null) {
            fail();
        }
    }

}
