package baseball.service;

import baseball.Ball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Validator.validateDuplication;

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
        Assertions.assertThatThrownBy(() -> {
                      for (String inputSplit : inputSplits) {
                          Ball ball = new Ball(Integer.parseInt(inputSplit));
                          validateDuplication(playerBalls, ball);
                          playerBalls.add(ball);
                      }
                  })
                  .isInstanceOf(IllegalArgumentException.class);
    }


}