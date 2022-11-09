package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @Test
    public void 숫자_생성_테스트(){
        Computer computer = new Computer();
        assertThat(computer.getNumeralList().size()).isEqualTo(Game.ANSWER_LENGTH);
    }
}