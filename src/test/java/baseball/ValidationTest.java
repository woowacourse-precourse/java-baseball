package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;
import java.util.List;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    public void 서로_다른_수_인지_확인() throws Exception {
        //given
        List<Integer> number = List.of(1, 2, 1);
        //when
        Throwable throwable = catchThrowable(() -> validation.validateUnlike(number));
        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

}