package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 애플리케이션 실행")
class GameTest {

    private Game game;

    @BeforeEach
    @DisplayName("테스트에 사용할 Game 인스턴스 생성")
    public void makeGameInstance() {
        this.game = new Game();
        assertThat(game).isInstanceOf(Game.class);
    }
}