package baseball;

import baseball.exception.ExceptionCode;
import baseball.exception.GameException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ValidateRandomNumberTest {
    @Test
    void 정상_테스트() {
        //given
        List<Integer> normal = List.of(1, 2, 3);
        //when
        Throwable exception = catchThrowable(() -> {
            validateRandomNumber(normal);
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
            validateRandomNumber(normal);
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
            validateRandomNumber(normal);
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
            validateRandomNumber(normal);
        });
        //then
        assertThat(exception)
                .isInstanceOf(GameException.class);
    }

    void validateRandomNumber(List<Integer> number) {
        if(number.size() != 3) {
            throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
        }
        for(Integer n : number) {
            if(n <= 0 || n > 9) {
                throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
            }
        }
        Set<Integer> set = new HashSet<>(number);
        if(set.size() != 3) {
            throw new GameException(ExceptionCode.RANDOM_NUMBER_NOT_VALID);
        }
    }
}
