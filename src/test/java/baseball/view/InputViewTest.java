package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {
    private InputView inputView = new InputView();

    @Test
    @DisplayName("유저에게 입력받는 세자리 수가 잘 들어오는지 테스트한다")
    void readGameInputTest() {
        super.run("123");
        assertThat(inputView.readGameInput())
                .isEqualTo(123);
    }

    @Test
    @DisplayName("유저에게 입력받는 컨트롤 값이 잘 들어오는지 테스트한다")
    void readGameControlInputTest() {
        super.run("1");
        assertThat(inputView.readGameControlInput())
                .isEqualTo(1);
    }

    @Override
    public void runMain() {
    }
}
