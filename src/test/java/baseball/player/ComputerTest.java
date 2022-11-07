package baseball.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("정답의 길이는 무조건 3이다.")
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