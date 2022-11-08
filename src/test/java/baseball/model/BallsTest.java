package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

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