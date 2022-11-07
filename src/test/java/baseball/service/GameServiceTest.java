package baseball.service;

import baseball.domain.baseball.Baseballs;
import baseball.domain.game.Result;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void progress_메서드_테스트_볼_스트라이크() {
        GameService gameService = new GameService();
        Baseballs baseballs1 = Baseballs.valueOf("123");
        Baseballs baseballs2 = Baseballs.valueOf("132");

        Result result = gameService.progress(baseballs1, baseballs2);

        assertThat(result.toString()).contains("2볼 1스트라이크");
    }

    @Test
    void progress_메서드_테스트_낫싱() {
        GameService gameService = new GameService();
        Baseballs baseballs1 = Baseballs.valueOf("123");
        Baseballs baseballs2 = Baseballs.valueOf("456");

        Result result = gameService.progress(baseballs1, baseballs2);

        assertThat(result.toString()).contains("낫싱");
    }
}