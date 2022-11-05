package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GenerateAnswerStatusTest {

    @Test
    void 정답생성_상태_뒤에_올_단계는_사용자_입력_상태입니다() {
        var status = new GenerateAnswerStatus().next(new BaseballGame());
        Assertions.assertThat(status).isInstanceOf(UserInputStatus.class);
    }

}