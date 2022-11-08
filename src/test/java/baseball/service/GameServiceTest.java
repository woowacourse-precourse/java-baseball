package baseball.service;

import baseball.model.numbers.Numbers;
import baseball.model.strikeandball.StrikeAndBall;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

class GameServiceTest {

    private final GameService gameService = new GameService();

    @Test
    public void compareAnswerNumberAndUnputNumber_메서드로_strike와_ball을_반환_테스트_1() {
        //given
        List<Integer> answer = Arrays.asList(3,6,9);
        List<Integer> userInput = Arrays.asList(3,6,9);

        Numbers answerNumber = new Numbers(answer);
        Numbers userInputNumber = new Numbers(userInput);

        //when
        StrikeAndBall strikeAndBall = gameService.compareAnswerNumberAndInputNumber(answerNumber, userInputNumber);

        //then

        Assertions.assertThat(strikeAndBall.getStrike()).isEqualTo(3);
        Assertions.assertThat(strikeAndBall.getBall()).isEqualTo(0);
    }

    @Test
    public void compareAnswerNumberAndUnputNumber_메서드로_strike와_ball을_반환_테스트_2() {
        //given
        List<Integer> answer = Arrays.asList(3,6,9);
        List<Integer> userInput = Arrays.asList(3,9,6);

        Numbers answerNumber = new Numbers(answer);
        Numbers userInputNumber = new Numbers(userInput);

        //when
        StrikeAndBall strikeAndBall = gameService.compareAnswerNumberAndInputNumber(answerNumber, userInputNumber);

        //then

        Assertions.assertThat(strikeAndBall.getStrike()).isEqualTo(1);
        Assertions.assertThat(strikeAndBall.getBall()).isEqualTo(2);
    }

    @Test
    public void compareAnswerNumberAndUnputNumber_메서드로_strike와_ball을_반환_테스트_3() {
        //given
        List<Integer> answer = Arrays.asList(3,6,9);
        List<Integer> userInput = Arrays.asList(6,9,3);

        Numbers answerNumber = new Numbers(answer);
        Numbers userInputNumber = new Numbers(userInput);

        //when
        StrikeAndBall strikeAndBall = gameService.compareAnswerNumberAndInputNumber(answerNumber, userInputNumber);

        //then

        Assertions.assertThat(strikeAndBall.getStrike()).isEqualTo(0);
        Assertions.assertThat(strikeAndBall.getBall()).isEqualTo(3);
    }

    @Test
    public void compareAnswerNumberAndUnputNumber_메서드로_strike와_ball을_반환_테스트_4() {
        //given
        List<Integer> answer = Arrays.asList(3,6,9);
        List<Integer> userInput = Arrays.asList(2,5,8);

        Numbers answerNumber = new Numbers(answer);
        Numbers userInputNumber = new Numbers(userInput);

        //when
        StrikeAndBall strikeAndBall = gameService.compareAnswerNumberAndInputNumber(answerNumber, userInputNumber);

        //then

        Assertions.assertThat(strikeAndBall.getStrike()).isEqualTo(0);
        Assertions.assertThat(strikeAndBall.getBall()).isEqualTo(0);
    }

}