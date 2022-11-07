package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class Feat2Test {

    @Test
    void 유저_숫자_입력_검사(){
        Number makeNumber = new Number();
        List<Integer> userNumber = makeNumber.inputNumberForTest("123");
        ArrayList<Integer> answerUserNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(userNumber).isEqualTo(answerUserNumber);
    }

    @Test
    void 유저_숫자_중복_검사(){
        Number makeNumber = new Number();
        assertThatThrownBy(() -> makeNumber.inputNumberForTest("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_숫자_범위_검사(){
        Number makeNumber = new Number();
        assertThatThrownBy(() -> makeNumber.inputNumberForTest("120"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_숫자_길이_검사(){
        Number makeNumber = new Number();
        assertThatThrownBy(() -> makeNumber.inputNumberForTest("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
