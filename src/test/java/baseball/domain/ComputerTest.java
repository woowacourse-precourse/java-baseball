package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상대방(컴퓨터)의 랜덤한 숫자 생성하기")
class ComputerTest {

    @Test
    @DisplayName("숫자의 크기는 3으로 고정")
    public void validNumberSize() {
        Computer computer = new Computer();
        List<Integer> randomNumber = computer.generateRandomNumber();

        assertThat(randomNumber.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("각 자리수는 1~9까지의 숫자만 사용")
    public void randomNumberHasOnlyOneToNine() {
        Computer computer = new Computer();
        List<Integer> randomNumber = computer.generateRandomNumber();

        assertThat(randomNumber).isNotIn(0).isNotIn(10);
    }


}