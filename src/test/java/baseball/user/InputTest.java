package baseball.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputTest {

    Input input = new Input();

    @Test
    public void 문자열로_받은_입력값이_리스트에_제대로_들어갔는지_확인(){
        // given
        List<Integer> inputList = new ArrayList<>();
        String inputString = "456";
        List<Integer> testList = Arrays.asList(4, 5, 6);
        // when
        inputList = input.inputDigit(inputString);
        // then
        Assertions.assertThat(inputList).isEqualTo(testList);
    }
}
