package baseball.view;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.GameResult;
import baseball.enums.GuessResultStatus;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberBaseballViewTest {

    private final NumberBaseballView numberBaseballView = new NumberBaseballView();

    @DisplayName("사용자의 숫자야구 입력에 따른 결과값 출력 테스트")
    @Test
    void printResult_allCases_success() {
        // given
        GameResult correctResult = new GameResult(List.of(3, 0));
        GameResult nothingResult = new GameResult(List.of(0, 0));
        GameResult strikeAndBallResult = new GameResult(List.of(2, 1));
        GameResult strikeOnlyResult = new GameResult(List.of(1, 0));
        GameResult ballOnlyResult = new GameResult(List.of(0, 2));

        // when
        // then
        assertThat(numberBaseballView.printResult(correctResult))
                .isEqualTo(GuessResultStatus.WIN);
        assertThat(numberBaseballView.printResult(nothingResult))
                .isEqualTo(GuessResultStatus.NOT_WIN);
        assertThat(numberBaseballView.printResult(strikeAndBallResult))
                .isEqualTo(GuessResultStatus.NOT_WIN);
        assertThat(numberBaseballView.printResult(strikeOnlyResult))
                .isEqualTo(GuessResultStatus.NOT_WIN);
        assertThat(numberBaseballView.printResult(ballOnlyResult))
                .isEqualTo(GuessResultStatus.NOT_WIN);
    }
}
