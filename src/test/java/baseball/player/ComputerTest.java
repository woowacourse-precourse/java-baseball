package baseball.player;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Valid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    public void setComputer() {
        this.computer = new Computer();
    }

    @Test
    void selectBalls_1_과_9_사이의_랜덤한_공을_3개_선택() {
        computer.selectBalls();
        String selectBalls = computer.getSelectBalls().toString();

        assertThat(selectBalls.length()).isEqualTo(3);
        assertThat(selectBalls).doesNotMatch(Valid.NOT_INPUT_NUMBER.getPattern());
    }
}