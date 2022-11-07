package baseball.domain;

import static baseball.domain.ComputerTest.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    @DisplayName("init() 메서드 호출시 score, computer 클래스 init 호출 테스트")
    void init() {
        // given
        Computer computer = Computer.of();
        Score score = Score.of();

        BaseballGame baseballGame = BaseballGame.builder()
                .computer(computer)
                .score(score)
                .build();

        // when
        baseballGame.init();
        List<Integer> randomNumbers = computer.getRandomNumbers();

        // then
        assertRandomNumbers(randomNumbers);  // random 3자리 1-9의 서로 다른 숫자
        assertThat(score.getBallCount()).isEqualTo(0);
        assertThat(score.getStrikeCount()).isEqualTo(0);
    }



}
