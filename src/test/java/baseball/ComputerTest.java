package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    @DisplayName("컴퓨터는 새로운 숫자 3개를 생성할 수 있다.")
    void setRandomNumbersTest() {
        // Given
        assertThat(computer.numbers.size()).isEqualTo(0);

        // When
        computer.setRandomNumbers();

        // Then
        assertAll("컴퓨터 숫자 검증",
                () -> assertThat(computer.numbers.size()).isEqualTo(3),
                () -> assertThat(computer.numbers.stream().distinct().count()).isEqualTo(3),
                () -> assertThat(computer.numbers.get(0)).isBetween(1, 9),
                () -> assertThat(computer.numbers.get(1)).isBetween(1, 9),
                () -> assertThat(computer.numbers.get(2)).isBetween(1, 9)
        );
    }

    @Test
    @DisplayName("컴퓨터는 3스트라이크 시 true를 반환한다.")
    void checkThreeStrikeTest_3Strike() {
        // Given
        computer.numbers.addAll(List.of(1, 2, 3));

        // When
        boolean result = computer.checkThreeStrike(List.of(1, 2, 3));

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("컴퓨터는 3스트라이크가 아닐시 false를 반환한다.")
    void checkThreeStrikeTest_Not3Strike() {
        // Given
        computer.numbers.addAll(List.of(1, 2, 3));

        // When Then
        assertAll("3스트라이크가 아닌 경우",
                () -> assertThat(computer.checkThreeStrike(List.of(4,5,6))).isFalse(),
                () -> assertThat(computer.checkThreeStrike(List.of(1,2,4))).isFalse(),
                () -> assertThat(computer.checkThreeStrike(List.of(3,2,1))).isFalse(),
                () -> assertThat(computer.checkThreeStrike(List.of(2,3,1))).isFalse()
        );
    }

    @Test
    @DisplayName("컴퓨터는 게임 재시작 여부를 확인할 수 있다_1 입력시 재시작")
    void restartTest_True() {
        // When
        boolean restart = computer.restart("1");

        // Then
        assertThat(restart).isTrue();
    }

    @Test
    @DisplayName("컴퓨터는 게임 재시작 여부를 확인할 수 있다_2 입력시 종료")
    void restartTest_False() {
        // When
        boolean restart = computer.restart("2");

        // Then
        assertThat(restart).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "아니요", "01"})
    @DisplayName("컴퓨터는 게임 재시작 여부를 확인할 수 있다_1, 2가 아닌 다른 값 입력시 예외 발생")
    void restartTest_IllegalArgumentException(String input) {
        // When Then
        assertThatThrownBy(() -> computer.restart(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못 입력되었습니다.");
    }
}