package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import static baseball.Exception.*;

public class ExceptionTest {
    @Test
    void 숫자가_3자리가_아닌_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> isOverThreeDigit(Arrays.asList(1, 2, 3, 4)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 동일한_숫자가_등장할_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> isSameNum(Arrays.asList(1, 2, 1)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력한_값이_숫자가_아닌_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> isNumber("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
