package baseball.service;

import baseball.domain.Baseball;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BaseballServiceTest {
    private final BaseballService baseballService = new BaseballServiceImpl();

    @Test
    public void judgeInputSizeNotMatch() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<Integer> goal = List.of(1, 2, 3);

        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> baseballService.judge(numbers, goal));
    }

    @Test
    public void judgeAllStrike() {
        //given
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> goal = List.of(1, 2, 3);

        //when
        Baseball result = baseballService.judge(numbers, goal);

        //then
        org.assertj.core.api.Assertions.assertThat(result.getStrike()).isEqualTo(3);
        org.assertj.core.api.Assertions.assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    public void judgeAllBall() {
        //given
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> goal = List.of(3, 1, 2);

        //when
        Baseball result = baseballService.judge(numbers, goal);

        //then
        org.assertj.core.api.Assertions.assertThat(result.getBall()).isEqualTo(3);
        org.assertj.core.api.Assertions.assertThat(result.getStrike()).isEqualTo(0);
    }

    @Test
    public void judgeNothing() {
        //given
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> goal = List.of(4, 5, 6);

        //when
        Baseball result = baseballService.judge(numbers, goal);

        //then
        org.assertj.core.api.Assertions.assertThat(result.getBall()).isEqualTo(0);
        org.assertj.core.api.Assertions.assertThat(result.getStrike()).isEqualTo(0);
    }

    @Test
    public void judgeMixed() {
        //given
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> goal = List.of(2, 4, 3);

        //when
        Baseball result = baseballService.judge(numbers, goal);

        //then
        org.assertj.core.api.Assertions.assertThat(result.getStrike()).isEqualTo(1);
        org.assertj.core.api.Assertions.assertThat(result.getBall()).isEqualTo(1);

    }
}