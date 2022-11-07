package baseball;

import baseball.game.StrikeNumberGenerator;
import baseball.object.StrikeNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberTest {

    @Test
    void getStrikeNumber_문자열_길이_3이하로_반환() {
        StrikeNumber number = StrikeNumberGenerator.getStrikeNumber();

        assertThatThrownBy(() -> number.numberAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 4 out of bounds for length 3");
    }

    @Test
    void getStrikeNumber_서로_다른_문자_반환() {
        StrikeNumber number = StrikeNumberGenerator.getStrikeNumber();

        Boolean isSame = (number.numberAt(0) == number.numberAt(1))
                && (number.numberAt(1) == number.numberAt(2))
                && (number.numberAt(0) == number.numberAt(2));

        assertThat(isSame).isEqualTo(false);
    }

    @Test
    void getStrikeNumber_1부터_9까지의_수로_구성하여_반환() {
        StrikeNumber number = StrikeNumberGenerator.getStrikeNumber();

        Boolean isException = false;
        for(int i = 0; i < number.getNumber().size(); i++){
            isException = isException || number.numberAt(i) < 1 || number.numberAt(i) > 9;
        }

        assertThat(isException).isEqualTo(false);
    }
}
