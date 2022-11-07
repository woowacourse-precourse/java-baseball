package baseball.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.number.BaseballNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ParticipantTest {


    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "1111", "11111", ""})
    void 입력받은_문자열의_길이는_3자리_입니다(final String input) {
        assertThatThrownBy(() -> new Participant(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participant.ERROR_SIZE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", "aaa", "1a1", "$$$", "11a", "가나라"})
    void 문자열의_내부_요소는_오직_정수로_이루어집니다(final String input) {
        assertThatThrownBy(() -> new Participant(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participant.ERROR_FORMAT);
    }

    @Test
    void 입력받은_문자열을_리스트로_반환합니다() {
        var participant = new Participant("123");
        var actual = participant.numbers();
        var expected = List.of(
                new BaseballNumber(1),
                new BaseballNumber(2),
                new BaseballNumber(3)
        );
        assertThat(actual).isEqualTo(expected);

    }
}