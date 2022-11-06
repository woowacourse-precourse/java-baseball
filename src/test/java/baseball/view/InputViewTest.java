package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @DisplayName("inputView를 구현한 구현체가 작동한다")
    @Test
    void 잘_작동() {
        InputView inputView = new InputView() {
            @Override
            public String readLine() {
                //Console.readLine()이 들어갈 부분
                return "hello";
            }
        };
        assertThat(inputView.readLine()).isEqualTo("hello");
    }
}
