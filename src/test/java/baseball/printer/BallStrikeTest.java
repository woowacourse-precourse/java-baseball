package baseball.printer;

import baseball.core.BallStrike;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallStrikeTest {

    @Test
    @DisplayName("낫싱")
    void case1() {
        //given
        BallStrike ballStrike = new BallStrike(0, 0);

        //when
        String res = ballStrike.toString();

        //then
        assertThat(res).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("1볼")
    void case2() {
        //given
        BallStrike ballStrike = new BallStrike(1, 0);

        //when
        String res = ballStrike.toString();

        //then
        assertThat(res).isEqualTo("1볼");
    }

    @Test
    @DisplayName("1스트라이크")
    void case3() {
        //given
        BallStrike ballStrike = new BallStrike(0, 1);

        //when
        String res = ballStrike.toString();

        //then
        assertThat(res).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void case4() {
        //given
        BallStrike ballStrike = new BallStrike(1, 1);

        //when
        String res = ballStrike.toString();

        //then
        assertThat(res).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("2볼 1스트라이크")
    void case5() {
        //given
        BallStrike ballStrike = new BallStrike(2, 1);

        //when
        String res = ballStrike.toString();

        //then
        assertThat(res).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("3스트라이크")
    void case6() {
        //given
        BallStrike ballStrike = new BallStrike(0, 3);

        //when
        String res = ballStrike.toString();

        //then
        assertThat(res).isEqualTo("3스트라이크");
    }
}