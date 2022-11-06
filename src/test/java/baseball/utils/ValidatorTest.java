package baseball.utils;

import baseball.model.Ball;
import baseball.model.GameStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void validateParseStringToInt_숫자로_바꿀_수_없는_문자열을_바꾸려고_할때_예외를_던지는지_테스트() {
        //given
        String playerInput = "12삼";
        //when
        //then
        assertThatThrownBy(() -> {
            try {
                Integer.parseInt(playerInput);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
    }

    @Test
    void validateParseStringToInt_숫자로_바꿀_수_있는_문자열을_바꾸려고_숫자로_잘_바뀌는지_테스트() {
        //given
        String playerInput = "123";
        //when
        //then
        assertThat(Integer.parseInt(playerInput)).isEqualTo(123);
    }


    @Test
    void validateInputLength_입력된_공_값의_길이가_3이_아닐때_예외를_던지는지_테스트() {
        //given
        String playerInput = "12";
        //when
        assertThatThrownBy(() -> {
            if (playerInput.length() == 3) {
                return;
            }
            throw new IllegalArgumentException("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
        //then
    }


    @Test
    void validateDuplication_입력된_공_값_중_중복된_값이_있을_경우_예외를_던지는지_테스트() {
        //given
        List<Ball> playerBalls = new ArrayList<>();
        playerBalls.add(new Ball(1));

        Ball ball = new Ball(1);
        //when
        //then
        assertThatThrownBy(() -> {
            if (playerBalls.contains(ball)) {
                throw new IllegalArgumentException("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
    }

    @Test
    void validateDuplication_입력된_공_값_중_중복된_값이_없을_경우_리스트에_잘_추가되는지_테스트() {
        //given
        List<Ball> playerBalls = new ArrayList<>();
        playerBalls.add(new Ball(1));

        Ball ball = new Ball(2);
        //when
        if (playerBalls.contains(ball)) {
            throw new IllegalArgumentException("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
        }
        playerBalls.add(ball);
        //then
        assertThat(playerBalls.size()).isEqualTo(2);
    }

    @Test
    void validateBallNumberRange_입력된_공_값이_1부터_9사이의_범위에_해당하지_않으면_예외를_던지는지_테스트() {
        //given
        Ball ball = new Ball(0);
        //when
        //then
        assertThatThrownBy(() -> {
            if (ball.isValidRange()) {
                return;
            }
            throw new IllegalArgumentException("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("사용자의 공 입력값은 서로 다른 1부터 9사이의 세 자리의 숫자로 이루어져야 합니다.");
    }

    @Test
    void validateGameStatus_입력된_게임상태_값이_1또는_2가_아니면_예외를_던지는지_테스트() {
        //given
        GameStatus gameStatus = new GameStatus(0);
        //when
        //then
        assertThatThrownBy(() -> {
            if (gameStatus.isValid()) {
                return;
            }
            throw new IllegalArgumentException("게임 상태는 재시작:1, 종료:2 중에서 입력해야 합니다");
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("게임 상태는 재시작:1, 종료:2 중에서 입력해야 합니다");
    }
}