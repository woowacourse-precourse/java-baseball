package baseball.domain;

import static baseball.domain.BaseballNumber.BASEBALL_NUMBER_UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void valueOf_메서드는_만약_1과_9사이의_값을_입력받으면_BaseballNumber_객체를_리턴한다(int number) {
        assertThat(BaseballNumber.valueOf(number)).isInstanceOf(BaseballNumber.class);
    }

    @Test
    void valueOf_메서드는_만약_주어진_범위보다_더_높은_값을_입력받으면_BaseballGameException을_던진다() {
        final Integer givenNumber = BASEBALL_NUMBER_UPPER_BOUND + 1;
        assertThatThrownBy(() -> BaseballNumber.valueOf(givenNumber))
                .isInstanceOf(BaseballGameException.class);
    }

    @Test
    void valueOf_메서드는_만약_주어진_범위보다_더_낮은_값을_입력받으면_BaseballGameException을_던진다() {
        final Integer givenNumber = BASEBALL_NUMBER_UPPER_BOUND + 1;
        assertThatThrownBy(() -> BaseballNumber.valueOf(givenNumber))
                .isInstanceOf(BaseballGameException.class);
    }
}
