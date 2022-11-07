package baseball.player;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    @Test
    void setNumber_정답_길이_확인() {
        // given
        Playable computer = new Computer();
        computer.inputAnswer();

        // when
        List<Integer> answer = computer.getAnswer();
        System.out.println(answer);

        // then
        assertThat(answer.size()).isEqualTo(3);
    }
}