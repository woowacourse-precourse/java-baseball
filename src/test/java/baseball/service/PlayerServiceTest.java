package baseball.service;

import baseball.Ball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Validator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerServiceTest {
    @Test
    void convertInputToBallList_중복값이_없을_때_문자열_입력값이_공_리스트로_잘_변환되는지_테스트() {
        //given
        String playerInput = "123";
        String[] inputSplits = playerInput.split("");

        List<Ball> playerBalls = new ArrayList<>();
        //when
        for (String inputSplit : inputSplits) {
            Ball ball = new Ball(Integer.parseInt(inputSplit));
            validateDuplication(playerBalls, ball);
            playerBalls.add(ball);
        }
        //then
        Assertions.assertThat(playerBalls.size())
                  .isEqualTo(playerInput.length());
    }

    @Test
    void convertInputToBallList_중복값이_있을_때_예외가_던져지는지_테스트() {
        //given
        String playerInput = "111";
        String[] inputSplits = playerInput.split("");

        List<Ball> playerBalls = new ArrayList<>();
        //when
        //then
        assertThatThrownBy(() -> {
            for (String inputSplit : inputSplits) {
                Ball ball = new Ball(Integer.parseInt(inputSplit));
                validateDuplication(playerBalls, ball);
                playerBalls.add(ball);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generatePlayerBalls_입력_값의_길이가_3이_아닐_경우_예외를_던지는지_테스트() {
        //given
        String playerInput = "12";
        //when
        //then
        assertThatThrownBy(() -> {
            validateInputLength(playerInput);
            validateParseStringToInt(playerInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generatePlayerBalls_숫자로_변경이_불가능한_문자열이_들어왔을때_예외가_던져지는지_테스트() {
        //given
        String playerInput = "12삼";
        //when
        validateInputLength(playerInput);
        //when, then
        assertThatThrownBy(() -> {
            validateParseStringToInt(playerInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}