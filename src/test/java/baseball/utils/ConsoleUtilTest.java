package baseball.utils;

import baseball.domain.BaseballDto;
import baseball.status.Comments;
import baseball.status.Constants;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleUtilTest {

    BaseballDto baseballDto;

    @BeforeEach
    void init() {
        baseballDto = new BaseballDto();
    }

    String execute(int ballCount, int strikeCount) {
        IntStream.range(Constants.ZERO_COUNT.getNumber(), ballCount)
                .forEach((i) -> baseballDto.addBallCount());
        IntStream.range(Constants.ZERO_COUNT.getNumber(), strikeCount)
                .forEach((i) -> baseballDto.addStrikeCount());

        return ConsoleUtil.ballAndStrikeOutput(baseballDto);
    }

    @Test
    void 출력_낫싱() {
        int ballCount = 0;
        int strikeCount = 0;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(Comments.NOTHING.getComment());
    }

    @Test
    void 출력_1스트라이크() {
        int ballCount = 0;
        int strikeCount = 1;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(strikeCount + Comments.STRIKE.getComment());
    }

    @Test
    void 출력_2스트라이크() {
        int ballCount = 0;
        int strikeCount = 2;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(strikeCount + Comments.STRIKE.getComment());
    }

    @Test
    void 출력_3스트라이크() {
        int ballCount = 0;
        int strikeCount = 3;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(
                strikeCount
                        + Comments.STRIKE.getComment()
                        + Comments.NEXT_LINE.getComment()
                        + Comments.GAME_END.getComment());
    }

    @Test
    void 출력_1볼() {
        int ballCount = 1;
        int strikeCount = 0;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(ballCount + Comments.BALL.getComment());
    }

    @Test
    void 출력_1볼_1스트라이크() {
        int ballCount = 1;
        int strikeCount = 1;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(
                ballCount
                        + Comments.BALL.getComment()
                        + Comments.SPACE.getComment()
                        + strikeCount
                        + Comments.STRIKE.getComment());
    }

    @Test
    void 출력_2볼() {
        int ballCount = 2;
        int strikeCount = 0;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(ballCount + Comments.BALL.getComment());
    }

    @Test
    void 출력_2볼_1스트라이크() {
        int ballCount = 2;
        int strikeCount = 1;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(
                ballCount
                        + Comments.BALL.getComment()
                        + Comments.SPACE.getComment()
                        + strikeCount
                        + Comments.STRIKE.getComment()
        );
    }

    @Test
    void 출력_3볼() {
        int ballCount = 3;
        int strikeCount = 0;
        String output = execute(ballCount, strikeCount);

        Assertions.assertThat(output).isEqualTo(ballCount + Comments.BALL.getComment());
    }
}