package baseball.user;

import baseball.Computer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputTest {

    Input input = new Input();


    @Test
    public void 문자열로_받은_입력값이_리스트에_제대로_들어갔는지_확인() {
        // given
        List<Integer> inputList = new ArrayList<>();
        String inputString = "456";
        List<Integer> testList = Arrays.asList(4, 5, 6);
        // when
        inputList = input.inputDigit(inputString);
        // then
        Assertions.assertThat(inputList).isEqualTo(testList);
    }

    @Test
    public void 입력값의_길이가_게임에_사용할_숫자의_길이와_같은지_확인() {
        // given
        List<Integer> inputList = List.of(1, 2, 3);
        int randomNumLength = Computer.RANDOM_NUMBER_LENGTH;
        // when

        // then
        Assertions.assertThat(inputList.size()).isEqualTo(randomNumLength);
    }

    @Test
    public void 입력값이_숫자일_때_확인() {
        // given
        String inputString = "123";
        // when
        boolean isNumber = input.isAllDigits(inputString);
        // then
        Assertions.assertThat(isNumber).isEqualTo(true);
    }

    @Test
    public void 입력값이_숫자가_아닐_때_확인() {
        // given
        String inputString = "일이삼";
        // when
        boolean isNumber = input.isAllDigits(inputString);
        // then
        Assertions.assertThat(isNumber).isEqualTo(false);
    }

    @Test
    public void 입력값이_범위안에_있는_경우_확인() {
        // given
        String inputRightString = "159";
        // when
        boolean isInRange = input.isDigitsInRange(inputRightString);
        // then
        Assertions.assertThat(isInRange).isEqualTo(true);
    }

    @Test
    public void 입력값이_범위안에_없는_경우_확인() {
        // given
        String inputWrongString = "109";
        // when
        boolean isInRange = input.isDigitsInRange(inputWrongString);
        // then
        Assertions.assertThat(isInRange).isEqualTo(false);
    }

    @Test
    public void 입력값이_모두_다른_값인지_확인() {
        // given
        String inputRightString = "159";
        // when
        boolean isAllDifferent = input.isAllDifferentDigit(inputRightString);
        // then
        Assertions.assertThat(isAllDifferent).isEqualTo(true);
    }

    @Test
    public void 입력값_중에_중복되는_값이_있을_때_확인() {
        // given
        String inputWrongString = "155";
        // when
        boolean isAllDifferent = input.isAllDifferentDigit(inputWrongString);
        // then
        Assertions.assertThat(isAllDifferent).isEqualTo(false);
    }
}
