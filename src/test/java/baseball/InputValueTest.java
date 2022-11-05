package baseball;

import baseball.domain.InputValue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InputValueTest{
    @Test
    void 리스트_변환() {
        InputValue inputValue = new InputValue();

        List<Integer> checkList = List.of(1,3,5);
        List<Integer> origin = inputValue.returnList("135");

        Assertions.assertThat(origin).isEqualTo(checkList);
    }
}
