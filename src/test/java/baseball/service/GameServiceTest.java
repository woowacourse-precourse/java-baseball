package baseball.service;

import baseball.dto.GameResultResponseDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameServiceTest {

    @Test
    void 플레이어가_1_9까지_서로다른수_3개선택후_결과반환() {
        GameService gameService = new GameService(List.of(4, 5, 6), List.of(1, 2, 3));
        GameResultResponseDto responseDto = gameService.playGame(List.of(1, 2, 3));

        assertThat(responseDto.getStrike()).isEqualTo(3);
        assertThat(responseDto.getBall()).isEqualTo(0);
        assertThat(responseDto.isGameEnd()).isTrue();
    }

    @Test
    void 플레이어의_볼을_다시입력후_결과확인() {
        GameService gameService = new GameService(List.of(1, 2, 3), List.of(1, 2, 3));
        GameResultResponseDto responseDto = gameService.playGame(List.of(4, 5, 6));

        assertThat(responseDto.getStrike()).isEqualTo(0);
        assertThat(responseDto.getBall()).isEqualTo(0);
        assertThat(responseDto.isGameEnd()).isFalse();
    }
}
