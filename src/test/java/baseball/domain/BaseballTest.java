package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    @Test
    void 전부_스트라이크일_때() throws Exception {
        //given
        Baseball baseball = new Baseball(new Computer());

        //when
        baseball.comparingResult(baseball.getAnswer());

        //then
        int balls = baseball.getResult()[0];
        int strikes = baseball.getResult()[1];

        assertThat(strikes).isEqualTo(3);
        assertThat(balls).isEqualTo(0);
    }

    @Test
    void 전부_볼() throws Exception {
        //given
        Baseball baseball = new Baseball(new Computer());

        StringBuilder sb = new StringBuilder(baseball.getAnswer());
        sb.append(sb.charAt(0));
        sb.deleteCharAt(0);

        //when
        baseball.comparingResult(sb.toString());

        //then
        int balls = baseball.getResult()[0];
        int strikes = baseball.getResult()[1];

        assertThat(strikes).isEqualTo(0);
        assertThat(balls).isEqualTo(3);
    }

    @Test
    void 낫싱() throws Exception {
        Baseball baseball = new Baseball(new Computer());

        //when
        baseball.comparingResult("000");

        //then
        int balls = baseball.getResult()[0];
        int strikes = baseball.getResult()[1];

        assertThat(strikes).isEqualTo(0);
        assertThat(balls).isEqualTo(0);
    }
}