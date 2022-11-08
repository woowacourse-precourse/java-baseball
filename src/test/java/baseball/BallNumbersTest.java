package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumbersTest {

    BallNumbers expectedBallNumbers = new BallNumbers(Arrays.asList(new BallNumber(0, 1), new BallNumber(1, 2), new BallNumber(2, 3)));

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

    @Test
    void BallNumbers와_BallNumber_비교_스트라이크() {
        //given
        BallNumber ballNumber = new BallNumber(0, 1);

        //when
        BallStatus ballStatus = expectedBallNumbers.compareToBallNumber(ballNumber);

        //then
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void BallNumbers와_BallNumber_비교_볼() {
        //given
        BallNumber ballNumber = new BallNumber(1, 1);

        //when
        BallStatus ballStatus = expectedBallNumbers.compareToBallNumber(ballNumber);

        //then
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void BallNumbers와_BallNumber_비교_낫띵() {
        //given
        BallNumber ballNumber = new BallNumber(0, 4);

        //when
        BallStatus ballStatus = expectedBallNumbers.compareToBallNumber(ballNumber);

        //then
        Assertions.assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void BallNumbers와_BallNumbers_비교_3스트라이크() {
        //given
        BallNumbers actualBallNumbers = new BallNumbers(Arrays.asList(new BallNumber(0, 1), new BallNumber(1, 2), new BallNumber(2, 3)));

        //when
        GameResult gameResult = expectedBallNumbers.compareToBallNumbers(actualBallNumbers);

        //then
        Assertions.assertThat(gameResult).isEqualTo(new GameResult(3, 0));
    }

    @Test
    void BallNumbers와_BallNumbers_비교_1스트라이크_1볼() {
        //given
        BallNumbers actualBallNumbers = new BallNumbers(Arrays.asList(new BallNumber(0, 2), new BallNumber(1, 6), new BallNumber(2, 3)));

        //when
        GameResult gameResult = expectedBallNumbers.compareToBallNumbers(actualBallNumbers);

        //then
        Assertions.assertThat(gameResult).isEqualTo(new GameResult(1, 1));
    }

    @Test
    void BallNumbers와_BallNumbers_비교_낫싱() {
        //given
        BallNumbers actualBallNumbers = new BallNumbers(Arrays.asList(new BallNumber(0, 7), new BallNumber(1, 8), new BallNumber(2, 9)));

        //when
        GameResult gameResult = expectedBallNumbers.compareToBallNumbers(actualBallNumbers);

        //then
        Assertions.assertThat(gameResult).isEqualTo(new GameResult(0, 0));
    }
}
