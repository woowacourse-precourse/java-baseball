package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    Player player = new Player();

    @ValueSource(strings = {"368", "124", "852", "465", "987"})
    @ParameterizedTest
    void 사용자로부터_3자리_수_예측값을_입력받는다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(player.getInputNumbersFromConsole()).isEqualTo(input);
    }

    @ValueSource(strings = {"woo", "가나다", "5", "1248", "68", "111", "202", "abcd", "^-^"})
    @ParameterizedTest
    void 사용자로부터_입력받은_수가_조건에_어긋나는_경우_예외처리한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Player::getInputNumbersFromConsole).isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(value = {
            "965 : 9 : 6 : 5",
            "473 : 4 : 7 : 3",
            "182 : 1 : 8 : 2",
            "257 : 2 : 5 : 7",
            "169 : 1 : 6 : 9",
            "934 : 9 : 3 : 4"
    }, delimiter = ':')
    @ParameterizedTest
    void 입력된_문자열을_정수_리스트로_변경한다(String inputNumbersString, int one, int two, int three) {
        System.setIn(new ByteArrayInputStream(inputNumbersString.getBytes()));

        List<Integer> expect = new ArrayList<>(Arrays.asList(one, two, three));
        List<Integer> result = player.getInputNumberAsList();

        assertThat(result).isEqualTo(expect);
    }

    @CsvSource(value = {
            "1 : true",
            "2 : false"
    }, delimiter = ':')
    @ParameterizedTest
    void 재시작_혹은_게임_완전_종료_여부를_사용자_입력으로_확인한다(String input, boolean expect) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(player.getRestartOrEnd()).isEqualTo(expect);
    }

    @ValueSource(strings = {"3", "4", "5", "1111", "abc", "^%$"})
    @ParameterizedTest
    void 사용자의_재시작_혹은_게임_완전_종료_여부_응답이_조건에_어긋나는_경우_예외_처리한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(Player::getRestartOrEnd).isInstanceOf(IllegalArgumentException.class);
    }
}