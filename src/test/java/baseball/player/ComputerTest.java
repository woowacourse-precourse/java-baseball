package baseball.player;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @Test
    void setNumber_정답_길이_확인() {
        Playable computer = new Computer();
        computer.setNumber();
        List<Integer> answer = computer.getNumber();
        assertThat(answer.size()).isEqualTo(3);
    }
}