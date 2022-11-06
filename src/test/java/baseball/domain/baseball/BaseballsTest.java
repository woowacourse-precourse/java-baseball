package baseball.domain.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class BaseballsTest {

    @Mock
    List<Baseball> mockList;

    @InjectMocks
    Baseballs computerBaseballs;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @RepeatedTest(100)
    void random_메서드_검증() {
        int result =
                (int) Baseballs.random()
                        .getBaseballs()
                        .stream()
                        .filter(number -> Baseball.MIN_BASEBALL_NUMBER <= number.getNumber() &&
                                number.getNumber() <= Baseball.MAX_BASEBALL_NUMBER)
                        .count();

        assertThat(result).isEqualTo(3);
    }

    @Test
    void toBaseballs_메서드로_입력받은_수를_Baseballs객체로_만들기() {

        List<Integer> result =
                Baseballs.valueOf("123")
                        .getBaseballs()
                        .stream()
                        .map(Baseball::getNumber)
                        .collect(Collectors.toList());

        assertAll(
                () -> assertThat(result.size()).isEqualTo(3),
                () -> assertThat(result).contains((int)'1'),
                () -> assertThat(result).contains((int)'2'),
                () -> assertThat(result).contains((int)'3')
        );
    }

    @Test
    void 입력이_3글자가_아닌경우_예외() {
        assertAll(
                () -> assertThatThrownBy(() -> Baseballs.valueOf("12"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Baseballs.NOT_THREE_LETTERS_MESSAGE),
                () -> assertThatThrownBy(() -> Baseballs.valueOf("1345"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Baseballs.NOT_THREE_LETTERS_MESSAGE)
        );
    }

    @Test
    void 중복된_숫자_입력_예외() {
        assertThatThrownBy(() -> Baseballs.valueOf("112"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(Baseballs.DUPLICATE_MESSAGE);
    }

    @Test
    void 스트라이크_갯수_세기() {
        Baseballs computerBaseballs = Baseballs.valueOf("123");
        Baseballs userBaseballs1 = Baseballs.valueOf("145");
        Baseballs userBaseballs2 = Baseballs.valueOf("163");
        Baseballs userBaseballs3 = Baseballs.valueOf("123");

        assertAll(
                () -> assertThat(computerBaseballs.getStrike(userBaseballs1)).isEqualTo(1),
                () -> assertThat(computerBaseballs.getStrike(userBaseballs2)).isEqualTo(2),
                () -> assertThat(computerBaseballs.getStrike(userBaseballs3)).isEqualTo(3)
        );
    }

    @Test
    void 볼_갯수_세기() {
        Baseballs computerBaseballs = Baseballs.valueOf("123");
        Baseballs userBaseballs1 = Baseballs.valueOf("215");
        Baseballs userBaseballs2 = Baseballs.valueOf("163");
        Baseballs userBaseballs3 = Baseballs.valueOf("312");

        assertAll(
                () -> assertThat(computerBaseballs.getBall(userBaseballs1)).isEqualTo(2),
                () -> assertThat(computerBaseballs.getBall(userBaseballs2)).isEqualTo(0),
                () -> assertThat(computerBaseballs.getBall(userBaseballs3)).isEqualTo(3)
        );
    }
}