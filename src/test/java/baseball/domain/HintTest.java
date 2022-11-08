package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HintTest {

    @Test
    void ball을_증가시킨다() {
        // given
        Hint hint = new Hint();

        // when
        hint.increaseBall();

        // then
        Assertions.assertThat(hint.getBallMessage()).isEqualTo("1볼");
    }

    @Test
    void strike를_증가시킨다() {
        // given
        Hint hint = new Hint();

        // when
        hint.increaseStrike();

        // then
        Assertions.assertThat(hint.getStrikeMessage()).isEqualTo("1스트라이크");
    }

    @Test
    void ball이_있으면_TRUE를_반환한다() {
        // given
        Hint hint = new Hint();
        hint.increaseBall();

        // when
        boolean isExistsBall = hint.isExistsBall();

        // then
        assertTrue(isExistsBall);
    }

    @Test
    void ball이_없으면_FALSE를_반환한다() {
        // given
        Hint hint = new Hint();

        // when
        boolean isExistsBall = hint.isExistsBall();

        // then
        assertFalse(isExistsBall);
    }

    @Test
    void strike가_있으면_TRUE를_반환한다() {
        // given
        Hint hint = new Hint();
        hint.increaseStrike();

        // when
        boolean isExistsStrike = hint.isExistsStrike();

        // then
        assertTrue(isExistsStrike);
    }

    @Test
    void strike가_없으면_FALSE를_반환한다() {
        // given
        Hint hint = new Hint();

        // when
        boolean isExistsStrike = hint.isExistsStrike();

        // then
        assertFalse(isExistsStrike);
    }

    @Test
    void 스트라이크가_3개면_TRUE를_반환한다() {
        // given
        Hint hint = new Hint();
        hint.increaseStrike();
        hint.increaseStrike();
        hint.increaseStrike();

        // when
        boolean isAllStrike = hint.isAllStrike();

        // then
        assertTrue(isAllStrike);
    }

}
