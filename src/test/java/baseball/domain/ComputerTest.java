package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void 컴퓨터_생성_및_랜덤수_세팅() throws Exception {
        //given
        Computer computer = new Computer();

        //when
        computer.setAnswerByRandom();

        //then
        long count = computer.getAnswer().chars()
                .distinct()
                .count();

        System.out.println("computer.getAnswer() = " + computer.getAnswer());

        assertThat(count).isEqualTo(3);
        assertThat(computer.getAnswer().length()).isEqualTo(3);
    }
}