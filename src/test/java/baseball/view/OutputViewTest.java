package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseballGameResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("OutputView 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final OutputView sut = OutputView.INSTANCE;

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
    void printGameStart_메서드는_숫자_야구_게임을_시작합니다_라는_문자를_화면에_출력한다() {
        final String consolePrint = "숫자 야구 게임을 시작합니다.\n";
        sut.printGameStart();
        assertThat(output.toString()).isEqualTo(consolePrint);
    }

    @Test
    void printGameEnd_메서드는_3개의_숫자를_모두_맞히셨습니다_게임_종료_라는_문자를_화면에_출력한다() {
        final String consolePrint = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
        sut.printGameEnd();
        assertThat(output.toString()).isEqualTo(consolePrint);
    }

    @Test
    void printGameResult_메서드는_게임의_결과를_화면에_출력한다() {
        final String consolePrint = "2볼\n";
        BaseballGameResult baseballGameResult = BaseballGameResult._2_BALL;
        sut.printGameResult(baseballGameResult);
        assertThat(output.toString()).isEqualTo(consolePrint);
    }
}
