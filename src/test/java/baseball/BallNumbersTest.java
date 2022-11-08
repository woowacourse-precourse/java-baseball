package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumbersTest {

    @Test
    void 중복값을_가지는_BallNumbers_객체_생성시_예외_발생() {
        //given
        List<BallNumber> ballNumbers = Arrays.asList(new BallNumber(0, 1), new BallNumber(1, 1), new BallNumber(2, 3));

        //then
        assertThatThrownBy(() -> new BallNumbers(ballNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("서로 다른 임의의 3자리의 수를 입력해주세요.");
    }

    @Test
    void 중복_인덱스_값을_가지는_BallNumbers_객체_생성시_예외_발생() {
        //given
        List<BallNumber> ballNumbers = Arrays.asList(new BallNumber(0, 1), new BallNumber(0, 2), new BallNumber(2, 3));

        //then
        assertThatThrownBy(() -> new BallNumbers(ballNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("서로 다른 위치의 3자리의 수를 입력해주세요.");
    }

    @Test
    void 리스트의_크기가_3이_아닌_BallNumbers_객체_생성시_예외_발생() {
        //given
        List<BallNumber> size2ballNumbers = Arrays.asList(new BallNumber(0, 1), new BallNumber(1, 2));

        //then
        assertThatThrownBy(() -> new BallNumbers(size2ballNumbers))
                .isExactlyInstanceOf(IllegalArgumentException.class).hasMessage("3자리의 수를 입력해주세요.");
    }
}
