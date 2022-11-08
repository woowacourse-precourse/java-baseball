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

class RefereeTest {

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
    @DisplayName("심판은 컴퓨터 번호 리스트를 받는다.")
    void receiveComputerNumbers() {
        // given
        List<Integer> expectedValue = List.of(1, 2, 3);

        Rule rule = new Rule();
        Referee referee = new Referee(rule);

        // when
        referee.receiveComputerNumbers(expectedValue);

        // then
        List<Integer> selectedNumbers = rule.getSelectedNumbers();
        assertThat(expectedValue).isEqualTo(selectedNumbers);
    }

    @Test
    @DisplayName("심판은 플레이어의 번호 리스트를 받는다.")
    void receivePlayerNumbers() {
        // given
        List<Integer> expectedValue = List.of(1, 2, 3);

        Rule rule = new Rule();
        Referee referee = new Referee(rule);

        // when
        referee.receivePlayerNumbers(expectedValue);
        ;

        // then
        List<Integer> refereePlayerNumbers = referee.getPlayerNumbers();
        assertThat(expectedValue).isEqualTo(refereePlayerNumbers);
    }

    @Test
    @DisplayName("숫자를 부른 후 뷰를 판한 하게 해주는 ViewService 반환 및 콘솔 출력 값 테스트")
    void answerNumber() {
        // given
        String expectedString = "3스트라이크\n"
                + GameMessage.END.getMessage()
                + "\n" + GameMessage.RESTART_OR_END.getMessage()
                + "\n";

        Referee referee = new Referee(new Rule());
        referee.receiveComputerNumbers(List.of(1, 2, 3));
        referee.receivePlayerNumbers(List.of(1, 2, 3));

        // when
        ViewService viewService = referee.answerNumber();
        viewService.countOfViewCheck();

        // then
        assertThat(viewService).isNotNull();
        assertThat(viewService).isInstanceOf(ViewService.class);
        assertThat(outputStream.toString()).isEqualTo(expectedString);
    }
}