package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.UI.ResultView;
import baseball.model.Result;
import baseball.model.State;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class ResultTest extends NsTest {
    @Test
    void test_ResultView_RESTART(){

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ResultView resultView = new ResultView();
        resultView.printResult(State.FINISH);
        assertThat(resultView.getResult()).isEqualTo(Result.RESTART);
    }

    @Test
    void test_ResultView_FINISH(){

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ResultView resultView = new ResultView();
        resultView.printResult(State.FINISH);
        assertThat(resultView.getResult()).isEqualTo(Result.FINISH);
    }

    @Test
    void test_ResultView_ERROR(){

        String input = "안끝낼래!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ResultView resultView = new ResultView();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> resultView.printResult(State.FINISH))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
