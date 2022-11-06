package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeAndBallCountTest {

    @Test
    @DisplayName("낫싱인 경우")
    void isNothing() throws Exception {
        //given
        Target target = new Target(List.of(1, 2, 3));
        BallCountGuess ballCountGuess = new BallCountGuess("456");
        String expect = BallCountMessage.NOTHING_KO.toString();
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("3볼인 경우")
    void is3Ball() throws Exception {
        //given
        Target target = new Target(List.of(1, 2, 3));
        BallCountGuess ballCountGuess = new BallCountGuess("312");
        String expect = "3볼 ";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("2볼인 경우")
    void is2Ball() throws Exception {
        //given
        Target target = new Target(List.of(1, 2, 3));
        BallCountGuess ballCountGuess = new BallCountGuess("912");
        String expect = "2볼 ";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("1볼인 경우")
    void is1Ball() throws Exception {
        //given
        Target target = new Target(List.of(1, 2, 3));
        BallCountGuess ballCountGuess = new BallCountGuess("982");
        String expect = "1볼 ";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("1볼 1스트라이크인 경우")
    void is1Ball1Strike() throws Exception {
        //given
        Target target = new Target(List.of(2, 6, 5));
        BallCountGuess ballCountGuess = new BallCountGuess("685");
        String expect = "1볼 1스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("2볼 1스트라이크인 경우")
    void is2Ball1Strike() throws Exception {
        //given
        Target target = new Target(List.of(2, 6, 5));
        BallCountGuess ballCountGuess = new BallCountGuess("625");
        String expect = "2볼 1스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }
    @Test
    @DisplayName("1스트라이크인 경우")
    void is1Strike() throws Exception {
        //given
        Target target = new Target(List.of(2, 6, 5));
        BallCountGuess ballCountGuess = new BallCountGuess("745");
        String expect = "1스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("2스트라이크인 경우")
    void is2Strike() throws Exception {
        //given
        Target target = new Target(List.of(2, 6, 5));
        BallCountGuess ballCountGuess = new BallCountGuess("765");

        String expect = "2스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("3스트라이크인 경우")
    void is3Strike() throws Exception {
        //given
        Target target = new Target(List.of(2, 6, 5));
        BallCountGuess ballCountGuess = new BallCountGuess("265");
        String expect = "3스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("3스트라이크인 경우 Out 확인")
    void isOut() throws Exception {
        //given
        Target target = new Target(List.of(2, 6, 5));
        BallCountGuess ballCountGuess = new BallCountGuess("265");
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, ballCountGuess);
        boolean result = strikeAndBallCount.isOut();
        //then
        assertThat(result).isEqualTo(true);
    }



}