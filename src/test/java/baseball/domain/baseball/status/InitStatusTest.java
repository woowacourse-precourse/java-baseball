package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
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
    void 준비상태에서_next함수를_실행시키면_게임시작이_출력됩니다() {
        new InitStatus().next(new BaseballGame());
        Assertions.assertThat(outputStreamCaptor.toString().trim()).isEqualTo(InitStatus.GAME_START_MESSAGE);
    }

    @Test
    void 준비상태_다음에_올_클래스의_인스턴스는_정답_상태생성입니다() {
        var status = new InitStatus().next(new BaseballGame());
        Assertions.assertThat(status).isInstanceOf(GenerateAnswerStatus.class);
    }
}