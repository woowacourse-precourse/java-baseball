package baseball.Utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutputTest {

    @Test
    void makeOutputString_AllCntZero_returnNothingString() {
        int strikeCnt = 0;
        int ballCnt = 0;
        String str = Output.makeOutputString(strikeCnt, ballCnt);
        assertThat(str).isEqualTo("낫싱");
    }

    @Test
    void makeOutputString_WhenBallCntZero_returnStrikeString() {
        int strikeCnt = 2;
        int ballCnt = 0;
        String str = Output.makeOutputString(strikeCnt, ballCnt);
        assertThat(str).isEqualTo("2스트라이크");
    }

    @Test
    void makeOutputString_WhenStrikeCntZero_returnBallString() {
        int strikeCnt = 0;
        int ballCnt = 3;
        String str = Output.makeOutputString(strikeCnt, ballCnt);
        assertThat(str).isEqualTo("3볼");
    }

    @Test
    void makeOutputString_WhenNoneOfZero_returnString() {
        int strikeCnt = 1;
        int ballCnt = 2;
        String str = Output.makeOutputString(strikeCnt, ballCnt);
        assertThat(str).isEqualTo("2볼 1스트라이크");
    }
}