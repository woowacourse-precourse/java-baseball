package baseball.playing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;


class StrikeOrBallTest {

    @Test
    void 스트라이크_볼_체크() {
        StrikeOrBall strikeOrBall = new StrikeOrBall();
        Map<String, Integer> testMap = strikeOrBall.checkStrikeOrBall("123", "132");
        assertThat(testMap.get("Strike")).isEqualTo(1);
        assertThat(testMap.get("Ball")).isEqualTo(2);
    }

    @Test
    void 스트라이크_볼_출력(){
        StrikeOrBall strikeOrBall = new StrikeOrBall();
        assertThat(strikeOrBall.printStrikeOrBall("123","456"))
                .isEqualTo("낫싱");
        assertThat(strikeOrBall.printStrikeOrBall("123","123"))
                .isEqualTo("3스트라이크");
        assertThat(strikeOrBall.printStrikeOrBall("123","132"))
                .isEqualTo("2볼 1스트라이크");
        assertThat(strikeOrBall.printStrikeOrBall("123","312"))
                .isEqualTo("3볼");
        assertThat(strikeOrBall.printStrikeOrBall("123","145"))
                .isEqualTo("1스트라이크");
    }

}