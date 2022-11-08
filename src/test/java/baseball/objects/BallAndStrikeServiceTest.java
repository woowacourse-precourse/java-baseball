package baseball.objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallAndStrikeServiceTest {

    private BallAndStrikeService ballAndStrikeService;

    @BeforeEach
    public void setUp() {
        List<Integer> computerNumber = List.of(1, 2, 3);
        this.ballAndStrikeService = new BallAndStrikeService(computerNumber);
    }

    @Test
    @DisplayName("컴퓨터 리스트 숫자에 타겟 리스트의 숫자가 포함 되어있으며 자리수 까지 맞는 경우 테스트")
    void containsExactly() {
        // given
        List<Integer> targetNumber = List.of(1, 2, 3);

        int index = 1;
        Integer value = targetNumber.get(index);

        // when
        boolean result = ballAndStrikeService.containsExactly(value, index);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("컴퓨터 리스트 숫자에 타겟 리스트의 숫자가 포함 되어있는지 테스트")
    void contains() {
        // given
        List<Integer> targetNumber = List.of(2, 3, 4);

        int index = 1;
        Integer value = targetNumber.get(index);

        // when
        boolean result = ballAndStrikeService.contains(value);

        // then
        assertThat(result).isTrue();

    }

}