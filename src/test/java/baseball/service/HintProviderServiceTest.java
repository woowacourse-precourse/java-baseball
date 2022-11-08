package baseball.service;

import baseball.model.HintReq;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static baseball.service.HintProviderService.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HintProviderServiceTest {

    @Test
    void ball_개수(){
        assertThat(0).isEqualTo(ballCount(Arrays.asList(1, 2, 3),Arrays.asList(1, 2, 3)));
        assertThat(2).isEqualTo(ballCount(Arrays.asList(1, 2, 3),Arrays.asList(3, 2, 1)));
        assertThat(1).isEqualTo(ballCount(Arrays.asList(1, 3, 2),Arrays.asList(4, 2, 5)));
    }

    @Test
    void strike_개수(){
        assertThat(3).isEqualTo(strikeCount(Arrays.asList(1, 2, 3),Arrays.asList(1, 2, 3)));
        assertThat(1).isEqualTo(strikeCount(Arrays.asList(1, 2, 3),Arrays.asList(3, 2, 1)));
        assertThat(0).isEqualTo(strikeCount(Arrays.asList(1, 2, 3),Arrays.asList(4, 3, 5)));
    }

    @Test
    void 힌트제공(){
        int actualBall = 0;
        int actualStrike = 3;
        HintReq expect = Hint(Arrays.asList(1, 2, 3),Arrays.asList(1, 2, 3));
        assertThat(actualBall).isEqualTo(expect.getBallCount());
        assertThat(actualStrike).isEqualTo(expect.getStrikeCount());

        actualBall = 2;
        actualStrike = 1;
        expect = Hint(Arrays.asList(1, 2, 3),Arrays.asList(3, 2, 1));
        assertThat(actualBall).isEqualTo(expect.getBallCount());
        assertThat(actualStrike).isEqualTo(expect.getStrikeCount());

        actualBall = 1;
        actualStrike = 0;
        expect = Hint(Arrays.asList(1, 2, 3),Arrays.asList(4, 3, 5));
        assertThat(actualBall).isEqualTo(expect.getBallCount());
        assertThat(actualStrike).isEqualTo(expect.getStrikeCount());
    }
}