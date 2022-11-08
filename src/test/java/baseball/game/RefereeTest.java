package baseball.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RefereeTest extends NsTest {
    Referee referee = new Referee();

    @Test
    void _1볼() {
        boolean perfectAnswer = referee.isPerfectAnswer(List.of(1, 2, 3), List.of(4, 5, 1));
        assertThat(perfectAnswer).isFalse();
        assertThat(output()).isEqualTo("1볼");
    }

    @Test
    void _1볼_1스트라이크() {
        boolean perfectAnswer = referee.isPerfectAnswer(List.of(1, 2, 3), List.of(1, 3, 4));
        assertThat(perfectAnswer).isFalse();
        assertThat(output()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void _2볼() {
        boolean perfectAnswer = referee.isPerfectAnswer(List.of(1, 2, 3), List.of(4, 3, 1));
        assertThat(perfectAnswer).isFalse();
        assertThat(output()).isEqualTo("2볼");
    }

    @Test
    void _2볼_1스트라이크() {
        boolean perfectAnswer = referee.isPerfectAnswer(List.of(1, 2, 3), List.of(1, 3, 2));
        assertThat(perfectAnswer).isFalse();
        assertThat(output()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void _3볼() {
        boolean perfectAnswer = referee.isPerfectAnswer(List.of(1, 2, 3), List.of(2, 3, 1));
        assertThat(perfectAnswer).isFalse();
        assertThat(output()).isEqualTo("3볼");
    }

    @Test
    void _1스트라이크() {
        boolean perfectAnswer = referee.isPerfectAnswer(List.of(1, 2, 3), List.of(4, 5, 3));
        assertThat(perfectAnswer).isFalse();
        assertThat(output()).isEqualTo("1스트라이크");
    }

    @Test
    void _2스트라이크() {
        boolean perfectAnswer = referee.isPerfectAnswer(List.of(1, 2, 3), List.of(4, 2, 3));
        assertThat(perfectAnswer).isFalse();
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    void _3스트라이크() {
        boolean perfectAnswer = referee.isPerfectAnswer(List.of(1, 2, 3), List.of(1, 2, 3));
        assertThat(perfectAnswer).isTrue();
        assertThat(output()).isEqualTo("3스트라이크");
    }

    @Override
    protected void runMain() {

    }
}