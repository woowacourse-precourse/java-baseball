package baseball.domain.baseball.status;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.baseball.BaseballContextFake;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InitStatusTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 준비상태에서_next_함수를_실행시키면_게임시작이_출력됩니다() {
        new InitStatus().next(new BaseballContextFake());

        var actual = outputStreamCaptor.toString()
                .trim();

        assertThat(actual).isEqualTo(InitStatus.GAME_START_MESSAGE);
    }

    @Test
    void 준비상태_다음에_올_클래스의_인스턴스는_정답_생성상태_입니다() {
        var context = new BaseballContextFake();
        var status = new InitStatus().next(context);
        assertThat(status).isInstanceOf(GenerateAnswerStatus.class);
    }
}