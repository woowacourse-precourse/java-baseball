package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.UI.InputView;
import baseball.model.Input;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputTest extends NsTest {

    @Test
    void test_Input_String_toIntList(){
        String test = "123";
        List<Integer> testList = new Input(test).getBaseballNumberList();
        assertThat(testList).containsExactly(1, 2, 3);
    }



    @Test
    void test_InputView(){
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();
        inputView.getBaseballInput();
        assertThat(inputView.getInput().getBaseballNumberList())
                .containsExactly(1, 2, 3);
    }

    @Test
    void test_InputView_Invalid_Size_Error(){
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();

        assertSimpleTest(() ->
                assertThatThrownBy(inputView::getBaseballInput)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void test_InputView_Not_Numeric_Error(){
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();

        assertSimpleTest(() ->
                assertThatThrownBy(inputView::getBaseballInput)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void test_InputView_Duplication_Error(){
        String input = "122";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();

        assertSimpleTest(() ->
                assertThatThrownBy(inputView::getBaseballInput)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void test_InputView_No_Input_Error(){
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        InputView inputView = new InputView();

        assertSimpleTest(() ->
                assertThatThrownBy(inputView::getBaseballInput)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
