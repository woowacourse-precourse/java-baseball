package baseball;

import baseball.domain.GameResult;
import baseball.output.GameOutput;
import baseball.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    GameService gameService = new GameService();

    @Test
    @DisplayName("각 자리수가 1~9 범위인 랜덤 3자리수 생성")
    void makeRandomNumber() {
        List<Integer> randNumbers = gameService.makeRandomNumbers();
        assertThat(randNumbers.size()).isEqualTo(3);
        assertThat(randNumbers.stream().collect(Collectors.toSet()).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 결과 생성")
    void makeGameResult() {

        // 스트라이크 3
        GameResult gameResult1 = gameService.makeGameResult("123", List.of(1, 2, 3));
        assertThat(gameResult1.getStrike()).isEqualTo(3);
        assertThat(gameResult1.getBall()).isEqualTo(0);

        // 스트라이크 1, 볼 2
        GameResult gameResult2 = gameService.makeGameResult("123", List.of(1, 3, 2));
        assertThat(gameResult2.getStrike()).isEqualTo(1);
        assertThat(gameResult2.getBall()).isEqualTo(2);

        // 볼 3
        GameResult gameResult3 = gameService.makeGameResult("123", List.of(3, 1, 2));
        assertThat(gameResult3.getStrike()).isEqualTo(0);
        assertThat(gameResult3.getBall()).isEqualTo(3);

        // 낫싱
        GameResult gameResult4 = gameService.makeGameResult("123", List.of(4, 5, 6));
        assertThat(gameResult4.getStrike()).isEqualTo(0);
        assertThat(gameResult4.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크, 볼, 낫싱 출력")
    void gameResultOutput() {

        // 낫싱 (스트라이크 : 0, 볼 : 0)
        assertThat(GameOutput.makeGameResult(new GameResult(0, 0))).isEqualTo("낫싱");

        // 스트라이크 2
        assertThat(GameOutput.makeGameResult(new GameResult(2, 0))).isEqualTo("2스트라이크");

        // 스트라이크 2, 볼 1
        assertThat(GameOutput.makeGameResult(new GameResult(2, 1))).isEqualTo("1볼 2스트라이크");

        // 볼 3
        assertThat(GameOutput.makeGameResult(new GameResult(0, 3))).isEqualTo("3볼");
    }

    @Test
    @DisplayName("게임 시작 or 게임 종료 선택")
    void isRetryGame() {

        // 게임 재시작
        assertThat(gameService.isRetryGame("1")).isEqualTo(true);

        // 게임 종료
        assertThat(gameService.isRetryGame("2")).isEqualTo(false);
    }
}