package baseball.repository;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.ComputerNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class NumberBaseballRepositoryTest {

    private final NumberBaseballRepository numberBaseballRepository = NumberBaseballRepository.getInstance();

    @BeforeEach
    void clearStore() {
        numberBaseballRepository.clearNumberStore();
    }

    @DisplayName("generateComputerNumber(): 메서드로 임의의 서로다른 3개 숫자 정의 하는 반복 테스트")
    @RepeatedTest(100)
    void generate_computerNumber_success() {
        // given
        // when
        ComputerNumber computerNumber = numberBaseballRepository.generateComputerNumber();

        // then
        assertThat(computerNumber.getFirstNumber()).isNotEqualTo(computerNumber.getSecondNumber());
        assertThat(computerNumber.getFirstNumber()).isNotEqualTo(computerNumber.getThirdNumber());
        assertThat(computerNumber.getSecondNumber()).isNotEqualTo(computerNumber.getThirdNumber());
    }
}
