package baseball.service;

import baseball.domain.BaseballDto;
import baseball.domain.User;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameLogicTest {

    GameLogic gameLogic;
    User user;

    void init(List<Integer> computerNumbers, List<Integer> userNumbers) {
        gameLogic = new GameLogic(
                computerNumbers,
                new BaseballDto()
        );

        gameLogic.getBallAndStrikeCount(userNumbers);
    }

    @Test
    void 낫싱() {
        init(List.of(1, 2, 3), List.of(4, 5, 6));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(0);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(0);
    }

    @Test
    void 원스트라이크() {
        init(List.of(1, 2, 3), List.of(1, 4, 5));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(0);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(1);
    }

    @Test
    void 투스트라이크() {
        init(List.of(1, 2, 3), List.of(1, 2, 4));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(0);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(2);
    }

    @Test
    void 쓰리스트라이크() {
        init(List.of(1, 2, 3), List.of(1, 2, 3));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(0);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(3);
    }

    @Test
    void 원볼() {
        init(List.of(1, 2, 3), List.of(2, 4, 5));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(1);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(0);
    }

    @Test
    void 원볼_원스트라이크() {
        init(List.of(1, 2, 3), List.of(3, 2, 4));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(1);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(1);
    }

    @Test
    void 투볼() {
        init(List.of(1, 2, 3), List.of(2, 1, 4));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(2);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(0);
    }

    @Test
    void 투볼_원스트라이크() {
        init(List.of(1, 2, 3), List.of(2, 1, 3));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(2);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(1);
    }

    @Test
    void 쓰리볼() {
        init(List.of(1, 2, 3), List.of(3, 1, 2));

        Assertions.assertThat(gameLogic.baseballDto.getBall()).isEqualTo(3);
        Assertions.assertThat(gameLogic.baseballDto.getStrike()).isEqualTo(0);
    }
}