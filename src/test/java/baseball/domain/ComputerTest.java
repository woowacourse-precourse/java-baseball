package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void 컴퓨터_생성_및_랜덤수_세팅() throws Exception {
        //given
        Computer computer = new Computer();

        //when
        long count = computer.getAnswer().chars()
                .distinct()
                .count();

        //then
        assertThat(count).isEqualTo(3);
        assertThat(computer.getAnswer().length()).isEqualTo(3);
    }
}