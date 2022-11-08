package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallsTest {

    @Test
    void validateDuplicate_중복된_숫자_값이_있을때_예외가_반환되는지_테스트() {
        //given
        List<Ball> balls = List.of(new Ball(1),
                                   new Ball(1),
                                   new Ball(1));
        //when
        Set<Ball> ballSet = new HashSet<>(balls);
        //when, then
        assertThatThrownBy(() -> {
            if (ballSet.size() != balls.size()) {
                throw new IllegalArgumentException("입력된 숫자의 값에 중복된 값이 포함되어서는 안됩니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("입력된 숫자의 값에 중복된 값이 포함되어서는 안됩니다.");
    }

    @Test
    void validateDuplicate_중복된_숫자_값이_없을때_Set와_List의_크기가_같은지_테스트() {
        //given
        List<Ball> balls = List.of(new Ball(1),
                                   new Ball(2),
                                   new Ball(3));
        //when
        Set<Ball> ballSet = new HashSet<>(balls);
        //then
        assertThat(balls.size()).isEqualTo(ballSet.size());
    }

    @Test
    void validateSize_리스트의_사이즈가_3이_아닐_때_예외가_반환되는지_테스트() {

    }

    @Test
    void validateNumberRange_숫자가_1부터_9사이의_범위에서_벗어났을때_예외를_던지는지_테스트() {

    }

    @Test
    void addBall_숫자를_리스트에_추가할_때_리스트에_추가가_잘_되는지_테스트() {

    }

    @Test
    void generateResult_컴퓨터의_값과_플레이어의_값이_2볼_1스트라이크일_경우_결과가_잘_반환되는지_테스트() {
        //given
        Result result = new Result();
        List<Integer> computerValues = List.of(1, 2, 3);
        List<Integer> playerValues = List.of(1, 3, 2);
        //when
        for (int i = 0; i < computerValues.size(); i++) {
            if (Objects.equals(computerValues.get(i), playerValues.get(i))) {
                result.increaseStrikeCount();
                continue;
            }
            if (computerValues.contains(playerValues.get(i))) {
                result.increaseBallCount();
            }
        }
        //then
        assertThat(result.getBallCount()).isEqualTo(2);
        assertThat(result.getStrikeCount()).isEqualTo(1);
    }
}