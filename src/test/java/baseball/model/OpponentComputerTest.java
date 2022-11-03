package baseball.model;

import baseball.RandomUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class OpponentComputerTest {

    @Test
    void 상대방_생성과_동시에_랜덤_수_저장() {
        OpponentComputer opponentComputer = new OpponentComputer(RandomUtil.createRandomNumber());
        int opponentComputerNumber = opponentComputer.getNumber();
        assertThat(opponentComputerNumber).isNotNull();
    }

}
