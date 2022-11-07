package baseball.referee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RefereeTest {

    Referee referee = new Referee();

    @Test
    void 사용자_볼이_전부_틀린경우_낫싱반환_성공() throws Exception {
        String result = referee.evaluate("123", "456");

        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 사용자_볼이_전부_맞은경우_3스트라이크반환_성공() throws Exception {
        String result = referee.evaluate("123", "123");

        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 사용자_볼이_전부_볼인경우_3볼반환_성공() throws Exception {
        String result = referee.evaluate("123", "312");

        assertThat(result).isEqualTo("3볼");
    }

    @Test
    void 사용자_볼이_2개만_맞은경우_2스트라이크반환_성공() throws Exception {
        String result = referee.evaluate("123", "124");

        assertThat(result).isEqualTo("2스트라이크");
    }

    @Test
    void 사용자_볼이_1개맞고_2개의순서가틀린경우_2볼_1스트라이크반환_성공() throws Exception {
        String result = referee.evaluate("123", "321");

        assertThat(result).isEqualTo("2볼 1스트라이크");
    }
}