package baseball.domain.comparator;

import baseball.domain.number.BaseBallGameNumbers;
import baseball.domain.result.CompareResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Comparator 는 ")
class ComparatorTest {

    @Test
    @DisplayName("모든 숫자가 위치와 값이 같다면 3스트라이크")
    void resultIs_3스트라이크_whenAllNumberIsSamePosition() {
        // given
        Comparator comparator = new Comparator();
        String inputNumber = "123";
        BaseBallGameNumbers inputNumbers = new BaseBallGameNumbers(inputNumber);
        BaseBallGameNumbers resultNumbers = new BaseBallGameNumbers(inputNumber);

        // when
        CompareResult result = comparator.compare(inputNumbers, resultNumbers);

        // then
        assertThat(result.toString()).isEqualTo("3스트라이크");
        assertThat(result.isAnswer()).isTrue();
    }

    @Test
    @DisplayName("2개의 다른 위치 같은 숫자와 1개의 같은 위치 숫자인 경우 경우 2볼 1스트라이크")
    void resultIs_2볼_1스트라이크_when2NumberIsDifferentPositionAnd1NumberIsSamePosition() {
        // given
        Comparator comparator = new Comparator();
        String inputNumber = "123";
        String resultNumber = "321";
        BaseBallGameNumbers inputNumbers = new BaseBallGameNumbers(inputNumber);
        BaseBallGameNumbers resultNumbers = new BaseBallGameNumbers(resultNumber);

        // when
        CompareResult result = comparator.compare(inputNumbers, resultNumbers);

        // then
        assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
        assertThat(result.isAnswer()).isFalse();
    }

    @Test
    @DisplayName("1개의 다른 위치 같은 숫자와 2개의 같은 위치 숫자인 경우 경우 1볼 2스트라이크")
    void resultIs_1볼_2스트라이크_when1NumberIsDifferentPositionAnd2NumberIsSamePosition() {
        // given
        Comparator comparator = new Comparator();
        String inputNumber = "123";
        String resultNumber = "321";
        BaseBallGameNumbers inputNumbers = new BaseBallGameNumbers(inputNumber);
        BaseBallGameNumbers resultNumbers = new BaseBallGameNumbers(resultNumber);

        // when
        CompareResult result = comparator.compare(inputNumbers, resultNumbers);

        // then
        assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
        assertThat(result.isAnswer()).isFalse();
    }

    @Test
    @DisplayName("같은 숫자가 없는 경우 낫싱")
    void resultIs_낫싱_whenSameNumberIsNotExist() {
        // given
        Comparator comparator = new Comparator();
        String inputNumber = "123";
        String resultNumber = "456";
        BaseBallGameNumbers inputNumbers = new BaseBallGameNumbers(inputNumber);
        BaseBallGameNumbers resultNumbers = new BaseBallGameNumbers(resultNumber);

        // when
        CompareResult result = comparator.compare(inputNumbers, resultNumbers);

        // then
        assertThat(result.toString()).isEqualTo("낫싱");
        assertThat(result.isAnswer()).isFalse();
    }

    @Test
    @DisplayName("1개의 다른 위치 숫자만 있는 경우 1볼")
    void resultIs_1볼_when1NumberIsDifferentPosition() {
        // given
        Comparator comparator = new Comparator();
        String inputNumber = "123";
        String resultNumber = "436";
        BaseBallGameNumbers inputNumbers = new BaseBallGameNumbers(inputNumber);
        BaseBallGameNumbers resultNumbers = new BaseBallGameNumbers(resultNumber);

        // when
        CompareResult result = comparator.compare(inputNumbers, resultNumbers);

        // then
        assertThat(result.toString()).isEqualTo("1볼");
        assertThat(result.isAnswer()).isFalse();
    }

    @Test
    @DisplayName("1개의 같은 위치 숫자만 있는 경우 1스트라이크")
    void resultIs_1스트라이크_when1NumberIsSamePosition() {
        // given
        Comparator comparator = new Comparator();
        String inputNumber = "123";
        String resultNumber = "453";
        BaseBallGameNumbers inputNumbers = new BaseBallGameNumbers(inputNumber);
        BaseBallGameNumbers resultNumbers = new BaseBallGameNumbers(resultNumber);

        // when
        CompareResult result = comparator.compare(inputNumbers, resultNumbers);

        // then
        assertThat(result.toString()).isEqualTo("1스트라이크");
        assertThat(result.isAnswer()).isFalse();
    }
}