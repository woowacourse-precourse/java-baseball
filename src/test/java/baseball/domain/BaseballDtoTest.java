package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class BaseballDtoTest {

    BaseballDto baseballDto = new BaseballDto();

    @AfterEach
    void tearDown() {
        baseballDto.initializeBaseBallDto();
    }

    @Test
    void addBallCountTest() {
        int it = 3;

        for (int i = 0; i < it; i++) {
            baseballDto.addBallCount();
        }

        Assertions.assertThat(baseballDto.getBall()).isEqualTo(it);
    }

    @Test
    void addStrikeCountTest() {
        int it = 3;

        for (int i = 0; i < it; i++) {
            baseballDto.addStrikeCount();
        }

        Assertions.assertThat(baseballDto.getStrike()).isEqualTo(it);
    }

    @Test
    void isBallExistTest() {
        baseballDto.addBallCount();

        Assertions.assertThat(baseballDto.isBallExist()).isTrue();
    }

    @Test
    void isStrikeExistTest() {
        baseballDto.addStrikeCount();

        Assertions.assertThat(baseballDto.isStrikeExist()).isTrue();
    }

}