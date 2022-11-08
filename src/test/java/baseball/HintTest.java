package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HintTest {

    @Test
    public void 볼_힌트생성() {
        Hint strike = Hint.BALL;
        String strikeHintString = strike.hintString(2L);
        assertThat(strikeHintString).isEqualTo("2볼");
    }

    @Test
    public void 스트라이크_힌트생성() {
        Hint strike = Hint.STRIKE;
        String strikeHintString = strike.hintString(2L);
        assertThat(strikeHintString).isEqualTo("2스트라이크");
    }

    @Test
    public void 낫싱_힌트생성() {
        Hint strike = Hint.NOTHING;
        String strikeHintString = strike.hintString(2L);
        assertThat(strikeHintString).isEqualTo("낫싱");
    }
}
