package baseball;

import baseball.exception.GameException;
import baseball.gameComponents.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ValidateNumberTest {
    private Validator validator = new Validator();
    @Test
    void 정상_테스트() {
        //given
        List<Integer> normal = List.of(1, 2, 3);
        //when
        Throwable exception = catchThrowable(() -> {
            validator.validateNumber(normal);
        });
        //then
        assertThat(exception)
                .isNull();
    }

    @Test
    void 실패_세자리_테스트() {
        //given
        List<Integer> normal = List.of(1, 2, 3, 4);
        //when
        Throwable exception = catchThrowable(() -> {
            validator.validateNumber(normal);
        });
        //then
        assertThat(exception)
                .isInstanceOf(GameException.class);
    }

    @Test
    void 실패_세자리_테스트2() {
        //given
        List<Integer> normal = List.of(1, 2, 33);
        //when
        Throwable exception = catchThrowable(() -> {
            validator.validateNumber(normal);
        });
        //then
        assertThat(exception)
                .isInstanceOf(GameException.class);
    }

    @Test
    void 정상_중복_테스트() {
        //given
        List<Integer> normal = List.of(1, 2, 1);
        //when
        Throwable exception = catchThrowable(() -> {
            validator.validateNumber(normal);
        });
        //then
        assertThat(exception)
                .isInstanceOf(GameException.class);
    }
}
