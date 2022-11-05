package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserInputStatusTest extends NsTest {

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
    void 사용자입력상태_다음_상태는_비교상태입니다() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(() -> {
            run("123");
            var status = new UserInputStatus().next(new BaseballGame());
            Assertions.assertThat(status).isInstanceOf(CompareAnswerStatus.class);
        }, 1, 1, 1, 1, 1);

    }

    @Override
    protected void runMain() {

    }
}