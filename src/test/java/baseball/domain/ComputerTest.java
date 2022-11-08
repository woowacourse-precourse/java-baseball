package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상대방(컴퓨터)의 랜덤한 숫자 생성하기")
class ComputerTest {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int constantListSize = 3;
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
        assertThat(this.computer.getRandomNumbers().size()).isEqualTo(constantListSize);
    }

    @Test
    @DisplayName("각 자리수는 1~9까지의 숫자만 사용")
    public void randomNumberHasOnlyOneToNine() {
        for (Integer number : computer.getRandomNumbers()) {
            assertThat(number).isBetween(MIN, MAX);
        }
    }

    @Test
    @DisplayName("각 자리수는 각기 다른 숫자가 사용되어야 함")
    public void randomNumberElementsAllUnique() {
        assertThat(this.computer.getRandomNumbers()).doesNotHaveDuplicates();
    }


}