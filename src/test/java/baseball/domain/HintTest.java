package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


class HintTest {

    Hint hint = new Hint();

    @BeforeEach
    void init() {
        hint.init();
    }

    @ParameterizedTest
    @DisplayName("스코어 포인트 초기화 테스트")
    @EnumSource(names = {"STRIKE", "BALL"})
    void initTest(Score score) throws Exception {
        assertThat(hint.getScorePoint(score)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("스코어 포인트 증가 테스트")
    @EnumSource(names = {"STRIKE", "BALL"})
    void increasePointTest(Score score) throws Exception {
        hint.increasePoint(score);
        assertThat(hint.getScorePoint(score)).isEqualTo(1);
    }

}

