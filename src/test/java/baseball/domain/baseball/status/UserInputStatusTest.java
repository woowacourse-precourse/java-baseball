package baseball.domain.baseball.status;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.baseball.BaseballContextFake;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserInputStatusTest {

    @Test
    void 사용자입력상태_다음_상태는_비교상태입니다() {

        var status = new UserInputStatus();
        var context = new BaseballContextFake(status, List.of(1, 2, 3), List.of(1, 2, 3));

        assertThat(status.next(context)).isInstanceOf(CompareAnswerStatus.class);

    }
}