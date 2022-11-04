package baseball;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSystemTest {
    private static GameSystem gameSystem;
    @BeforeEach
    public void gameStart(){
      gameSystem = new GameSystem();
    }

    @DisplayName("게임 시작 문구 출력 테스트")
    @Test
    void 게임_시작_문구_출력_테스트(){
      assertThat(gameSystem.gameStart()).isEqualTo(" ");
    }
}
