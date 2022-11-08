package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    public void 컴퓨터_랜덤수_생성() throws Exception {
        //given
        Computer computer = new Computer();

        //when
        long count = computer.getAnswer()
                .chars()
                .distinct()
                .count();

        //then
        assertThat(count).isEqualTo(3);
        assertThat(computer.getAnswer().length()).isEqualTo(3);
    }
}
