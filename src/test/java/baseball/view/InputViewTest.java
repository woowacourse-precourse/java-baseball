package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.BaseballGameStatus;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("InputView 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final InputView sut = InputView.INSTANCE;

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restore() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void inputBaseballNumber_메서드는_숫자를_입력해주세요_라는_메시지를_출력하고_만약_숫자를_입력받으면_그대로_반환한다() {
        final String consolePrint = "숫자를 입력해주세요 : ";
        final InputStream inputStream = generateUserInput("123");
        System.setIn(inputStream);

        String baseballNumber = sut.inputBaseballNumber();

        assertThat(output.toString()).isEqualTo(consolePrint);
        assertThat(baseballNumber).isEqualTo("123");
    }

    @Test
    void inputBaseballNumber_메서드는_숫자를_입력해주세요_라는_메시지를_출력하고_만약_허용된_입력값이_아닌경우_IAE_예외를_던진다() {
        final String consolePrint = "숫자를 입력해주세요 : ";
        final InputStream inputStream = generateUserInput("144");
        System.setIn(inputStream);

        assertThatThrownBy(sut::inputBaseballNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void inputGameStatus_메서드는_게임_재시작_여부_메시지를_출력하고_만약_1을_입력받으면_BaseballGameStatus_Play를_리턴한다() {
        final String consolePrint = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
        final InputStream givenInput = generateUserInput("1");
        System.setIn(givenInput);

        BaseballGameStatus baseballGameStatus = sut.inputGameStatus();

        assertThat(output.toString()).isEqualTo(consolePrint);
        assertThat(baseballGameStatus).isEqualTo(BaseballGameStatus.PLAY);
    }

    private InputStream givenInput = generateUserInput("2");

    @Test
    void inputGameStatus_메서드는_게임_재시작_여부_메시지를_출력하고_만약_2를_입력받으면_BaseballGameStatus_STOP을_리턴한다() {
        final String consolePrint = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
        final InputStream givenInput = generateUserInput("2");
        System.setIn(givenInput);

        BaseballGameStatus baseballGameStatus = sut.inputGameStatus();

        assertThat(output.toString()).isEqualTo(consolePrint);
        assertThat(baseballGameStatus).isEqualTo(BaseballGameStatus.STOP);
    }

    @Test
    void inputGameStatus_메서드는_게임_재시작_여부_메시지를_출력하고_만약_허용된_입력값이_아닌경우_IllegalArgumentException_예외를_던진다() {
        InputStream inputStream = generateUserInput("3");
        System.setIn(inputStream);

        assertThatThrownBy(sut::inputGameStatus)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
