package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    @DisplayName("출력이 작동할 수 있다")
    @Test
    void 잘_작동() {
        OutputView outputView = new OutputView() {
            @Override
            public void print(String content) {
                assertThat(content).isEqualTo("hello");
            }

            @Override
            public void printError(String content) {
                assertThat(content).isEqualTo("error");
            }
        };
        outputView.print("hello");
        outputView.printError("error");
    }
}
