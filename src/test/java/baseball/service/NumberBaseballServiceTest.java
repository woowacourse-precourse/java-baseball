package baseball.service;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.ComputerNumber;
import baseball.sevice.NumberBaseballService;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class NumberBaseballServiceTest {

    private static final NumberBaseballService numberBaseballService = new NumberBaseballService();

    @BeforeAll
    void init_number() {
        numberBaseballService.initNumber();
    }

    @DisplayName("사용자 입력이 1 ~ 9 숫자가 아니라면 IllegalArgumentException 예외 발생 테스트")
    @Test
    void inputUserAnswer_fail_CauseNonNumeric() {
        // given
        String outOfRangeInput = "012";
        String nonNumericInput = "abc";

        // when
        // then
        assertThatThrownBy(() -> numberBaseballService.inputUserAnswer(outOfRangeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 9사이의 숫자만 입력해야 합니다.");
        assertThatThrownBy(() -> numberBaseballService.inputUserAnswer(nonNumericInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 9사이의 숫자만 입력해야 합니다.");
    }

    @DisplayName("사용자 입력이 1 ~ 9 사이의 숫자라면 정상 동작 테스트")
    @Test
    void inputUserAnswer_success() {
        // given
        String normalInput = "123";

        // when
        numberBaseballService.inputUserAnswer(normalInput);
    }

    @DisplayName("사용자 입력이 3글자가 아니라면 IllegalArgumentException 예외 발생 테스트")
    @Test
    void inputUserAnswer_fail_causeTooLongInput() {
        // given
        String tooManyInput = "1234";

        // when
        // then
        assertThatThrownBy(() -> numberBaseballService.inputUserAnswer(tooManyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3글자의 숫자를 입력해야 합니다.");
    }

    @DisplayName("사용자의 입력중 동일한 숫자가 있다면 IllegalArgumentException 예외 발생 테스트")
    @Test
    void inputUserAnswer_fail_causeSameNumber() {
        // given
        String sameNumberInput = "112";

        // when
        // then
        assertThatThrownBy(() -> numberBaseballService.inputUserAnswer(sameNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자는 모두 달라야 합니다.");
    }

    @DisplayName("스트라이크의 수 계산 테스트")
    @Test
    void getStrikeCount_success() {
        // given
        ComputerNumber computerNumber = new ComputerNumber(List.of(2, 3, 4));
        String userInput = "235";

        // when
        int strikeCount = numberBaseballService.getStrikeCount(computerNumber, userInput);

        // then
        assertThat(strikeCount).isEqualTo(2);
    }

    @DisplayName("볼의 수 계산 테스트")
    @Test
    void getBallCount_success() {
        // given
        ComputerNumber computerNumber = new ComputerNumber(List.of(2, 3, 4));
        String userInput = "325";

        // when
        int ballCount = numberBaseballService.getBallCount(computerNumber, userInput);

        // then
        assertThat(ballCount).isEqualTo(2);
    }

    @DisplayName("스트라이크, 볼 계산 병합 테스트")
    @Test
    void getStrikeAndBallCount_success() {
        // given
        ComputerNumber computerNumber = new ComputerNumber(List.of(2, 3, 4));
        String userInput = "245";

        // when
        int strikeCount = numberBaseballService.getStrikeCount(computerNumber, userInput);
        int ballCount = numberBaseballService.getBallCount(computerNumber, userInput);

        // then
        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(1);
    }
}
