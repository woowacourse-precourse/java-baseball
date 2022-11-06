package baseball.view;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.GameResult;
import baseball.enums.GuessResultType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberBaseballViewTest {

    private final NumberBaseballView numberBaseballView = new NumberBaseballView();

    @DisplayName("사용자의 숫자야구 입력에 따른 결과값 출력 테스트")
    @Test
    void printResult_allCases_success() {
        // given
        GameResult correctResult = new GameResult(3, 0);
        GameResult nothingResult = new GameResult(0, 0);
        GameResult strikeAndBallResult = new GameResult(2, 1);
        GameResult strikeOnlyResult = new GameResult(1, 0);
        GameResult ballOnlyResult = new GameResult(0, 2);

        // when
        // then
        assertThat(numberBaseballView.printResult(correctResult))
                .isEqualTo(GuessResultType.WIN);
        assertThat(numberBaseballView.printResult(nothingResult))
                .isEqualTo(GuessResultType.NOT_WIN);
        assertThat(numberBaseballView.printResult(strikeAndBallResult))
                .isEqualTo(GuessResultType.NOT_WIN);
        assertThat(numberBaseballView.printResult(strikeOnlyResult))
                .isEqualTo(GuessResultType.NOT_WIN);
        assertThat(numberBaseballView.printResult(ballOnlyResult))
                .isEqualTo(GuessResultType.NOT_WIN);
    }
}
