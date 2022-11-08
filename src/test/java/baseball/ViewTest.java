package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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
        assertEquals(actual, "457");

        then(view).should(times(1))
                .inputBaseballNumber();

    }

    @Test
    @DisplayName("view inputExitOrRestart() 호출 시 문자열이 반환되어야함")
    void inputExitOrRestart() {
        given(view.inputExitOrRestart()).willReturn("2");
        //when
        String actual = view.inputExitOrRestart();
        //then
        assertEquals(actual, "2");

        then(view).should(times(1))
                .inputExitOrRestart();

    }

    @Test
    @DisplayName("BaseballDto getResult() 를 통해 1볼 2스트라이크 가 출력되어야해")
    public void printBaseBallResult() {
        //given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        BaseBallDto baseBallDto = new BaseBallDto(2, 1);
        View testView = new View();
        //when
        testView.printBaseBallResult(baseBallDto);

        String actual = outputStreamCaptor.toString()
                .trim();
        //then
        assertEquals(actual, "1볼 2스트라이크");

    }
}
