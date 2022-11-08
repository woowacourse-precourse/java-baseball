package baseball.objects;

import baseball.view.message.GameMessage;
import baseball.view.service.ViewService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @Test
    @DisplayName("컴퓨터 숫자와 플레이어 숫자가 주어진 경우 결과를 판단하여 View 를 출력해준다.")
    void answerNumber() {
        // given
        Rule rule = new Rule();
        List<Integer> computerNumber = List.of(1, 2, 3);
        rule.selectedNumber(computerNumber);

        String expectedString = "3스트라이크\n"
                + GameMessage.END.getMessage()
                + "\n" + GameMessage.RESTART_OR_END.getMessage()
                + "\n";

        List<Integer> target = List.of(1, 2, 3);

        // when
        ViewService viewService = rule.answerNumber(target);
        viewService.check();

        // then
        assertThat(outputStream.toString()).isEqualTo(expectedString);
    }
}