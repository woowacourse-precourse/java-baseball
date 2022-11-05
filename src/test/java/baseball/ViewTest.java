package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


public class ViewTest {

    View view;

    @BeforeEach
    void init() {
        view = mock(View.class);
    }
    @Test
    @DisplayName("view inputBaseballNumber() 호출 시 문자열이 반환되어야함")
    void view_input_test() {
        given(view.inputBaseballNumber()).willReturn("457");
        //when
        String actual = view.inputBaseballNumber();
        //then
        Assertions.assertEquals(actual,"457");

        then(view).should(times(1))
                  .inputBaseballNumber();

    }
}
