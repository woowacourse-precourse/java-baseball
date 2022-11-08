package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상대방(컴퓨터)의 랜덤한 숫자 생성하기")
class ComputerTest {

    private Computer computer;

    @BeforeEach
    @DisplayName("테스트에 사용할 Computer 인스턴스 생성")
    public void makeComputerInstance() {
        this.computer = new Computer();
        assertThat(computer).isInstanceOf(Computer.class);
    }

    @Test
    @DisplayName("숫자의 크기는 3으로 고정")
    public void validNumberSize() {
        assertThat(this.computer.getRandomNumbers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("각 자리수는 1~9까지의 숫자만 사용")
    public void randomNumberHasOnlyOneToNine() {
        assertThat(this.computer.getRandomNumbers()).isNotIn(0).isNotIn(10);
    }

    @Test
    @DisplayName("각 자리수는 각기 다른 숫자가 사용되어야 함")
    public void randomNumberElementsAllUnique() {
        assertThat(this.computer.getRandomNumbers()).doesNotHaveDuplicates();
    }


}