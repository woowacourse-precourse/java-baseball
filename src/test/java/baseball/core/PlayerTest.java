package baseball.core;

import baseball.exception.DuplicateNumberException;
import baseball.exception.EachInputNumberOutOfRangeException;
import baseball.exception.InputNumberFormatException;
import baseball.exception.InputNumberOutOfRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @Test
    @DisplayName("정상 출력 케이스1")
    void successCase1() {
        //given
        String inputString = "528";
        List<Integer> expected = List.of(5, 2, 8);

        //when
        List<Integer> res = player.inputThreeNumbers(inputString);

        //then
        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("정상 출력 케이스2")
    void successCase2() {
        //given
        String inputString = "498";
        List<Integer> expected = List.of(4, 9, 8);

        //when
        List<Integer> res = player.inputThreeNumbers(inputString);

        //then
        assertThat(res).isEqualTo(expected);
    }

    @Test
    @DisplayName("올바른 숫자가 아닌 경우 - 문자")
    void inputNumberFormatException_case1() {
        //given
        String inputString = "hello";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(InputNumberFormatException.class)
                .hasMessage("잘못된 숫자 입력입니다. 입력 문자: " + inputString);
    }


    @Test
    @DisplayName("올바른 숫자가 아닌 경우 - 음수")
    void inputNumberFormatException_case2() {
        //given
        String inputString = "-123";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(InputNumberFormatException.class)
                .hasMessage("잘못된 숫자 입력입니다. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("1~9 사이의 숫자가 아닌 경우 - 012")
    void gameEachInputNumberOutOfRangeException_case1() {
        //given
        String inputString = "012";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(EachInputNumberOutOfRangeException.class)
                .hasMessage("1~9 사이의 숫자를 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("1~9 사이의 숫자가 아닌 경우 - 709")
    void gameEachInputNumberOutOfRangeException_case2() {
        //given
        String inputString = "709";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(EachInputNumberOutOfRangeException.class)
                .hasMessage("1~9 사이의 숫자를 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("3자리 숫자가 아닌 경우 - 1234")
    void gameInputNumberOutOfRangeException_case1() {
        //given
        String inputString = "1234";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(InputNumberOutOfRangeException.class)
                .hasMessage("123~789 사이의 숫자를 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("3자리 숫자가 아닌 경우 - 1244")
    void gameInputNumberOutOfRangeException_case2() {
        //given
        String inputString = "1244";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(InputNumberOutOfRangeException.class)
                .hasMessage("123~789 사이의 숫자를 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("3자리 숫자가 아닌 경우 - 12")
    void gameInputNumberOutOfRangeException_case3() {
        //given
        String inputString = "12";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(InputNumberOutOfRangeException.class)
                .hasMessage("123~789 사이의 숫자를 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("중복된 숫자가 있는 경우 - 144")
    void duplicateNumberException_case1() {
        //given
        String inputString = "144";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(DuplicateNumberException.class)
                .hasMessage("서로 다른 숫자를 입력해주세요. 입력 문자: " + inputString);
    }

    @Test
    @DisplayName("중복된 숫자가 있는 경우 - 221")
    void duplicateNumberException_case2() {
        //given
        String inputString = "221";

        //when then
        assertThatThrownBy(() -> player.inputThreeNumbers(inputString))
                .isInstanceOf(DuplicateNumberException.class)
                .hasMessage("서로 다른 숫자를 입력해주세요. 입력 문자: " + inputString);
    }
}