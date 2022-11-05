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
        List<Integer> target = List.of(1, 2, 3);
        List<Integer> guessValue = List.of(4, 5, 6);
        String expect = BallCountMessage.NOTHING_KO.toString();
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("3볼인 경우")
    void is3Ball() throws Exception {
        //given
        List<Integer> target = List.of(1, 2, 3);
        List<Integer> guessValue = List.of(3, 1, 2);
        String expect = "3볼 ";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("2볼인 경우")
    void is2Ball() throws Exception {
        //given
        List<Integer> target = List.of(1, 2, 3);
        List<Integer> guessValue = List.of(9, 1, 2);
        String expect = "2볼 ";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("1볼인 경우")
    void is1Ball() throws Exception {
        //given
        List<Integer> target = List.of(1, 2, 3);
        List<Integer> guessValue = List.of(9, 8, 2);
        String expect = "1볼 ";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("1볼 1스트라이크인 경우")
    void is1Ball1Strike() throws Exception {
        //given
        List<Integer> target = List.of(2, 6, 5);
        List<Integer> guessValue = List.of(6, 8, 5);
        String expect = "1볼 1스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("2볼 1스트라이크인 경우")
    void is2Ball1Strike() throws Exception {
        //given
        List<Integer> target = List.of(2, 6, 5);
        List<Integer> guessValue = List.of(6, 2, 5);
        String expect = "2볼 1스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }
    @Test
    @DisplayName("1스트라이크인 경우")
    void is1Strike() throws Exception {
        //given
        List<Integer> target = List.of(2, 6, 5);
        List<Integer> guessValue = List.of(7, 4, 5);
        String expect = "1스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("2스트라이크인 경우")
    void is2Strike() throws Exception {
        //given
        List<Integer> target = List.of(2, 6, 5);
        List<Integer> guessValue = List.of(7, 6, 5);
        String expect = "2스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("3스트라이크인 경우")
    void is3Strike() throws Exception {
        //given
        List<Integer> target = List.of(2, 6, 5);
        List<Integer> guessValue = List.of(2, 6, 5);
        String expect = "3스트라이크";
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        String result = strikeAndBallCount.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("3스트라이크인 경우 Out 확인")
    void isOut() throws Exception {
        //given
        List<Integer> target = List.of(2, 6, 5);
        List<Integer> guessValue = List.of(2, 6, 5);
        //when
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(target, guessValue);
        boolean result = strikeAndBallCount.isOut();
        //then
        assertThat(result).isEqualTo(true);
    }



}