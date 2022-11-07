package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ErrorViewTest {
    @DisplayName("내용이 잘 전달됨")
    @Test
    void 에러_뷰_테스트() {
        ErrorView errorView = new ErrorView() {
            @Override
            public void printError(String content) {
                assertThat(content).isEqualTo("hello");
            }
        };
        errorView.printError("hello");
    }
}
