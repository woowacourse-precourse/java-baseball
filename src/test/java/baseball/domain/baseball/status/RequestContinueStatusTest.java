package baseball.domain.baseball.status;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.baseball.BaseballContextFake;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RequestContinueStatusTest {
    @Test
    void 다음_입력_상태의_경우_1을입력하면_재시작으로_정답_초기화_상태가_됩니다() {
        var status = new RequestContinueStatus();
        var context = new BaseballContextFake(status, "1");

        var next = status.next(context);

        assertThat(next).isInstanceOf(GenerateAnswerStatus.class);
    }

    @Test
    void 다음_입력_상태의_경우_2을입력하면_종료상태가_됩니다() {
        var status = new RequestContinueStatus();
        var context = new BaseballContextFake(status, "2");

        var next = status.next(context);

        assertThat(next).isInstanceOf(GameEndStatus.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "$", "", " ", "  ", "##", "3"})
    void _1과_2를_제외한_값이_입력되면_오류가_발생합니다(final String input) {
        var status = new RequestContinueStatus();
        var context = new BaseballContextFake(status, input);

        assertThatThrownBy(() -> status.next(context))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RequestContinueStatus.ERROR_CONTINUOUS_INPUT);
    }

}