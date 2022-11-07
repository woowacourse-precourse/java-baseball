package baseball.service;
import baseball.service.GameStatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class GameStatusServiceTest {

    GameStatusService gameStatusService;

    @BeforeEach
    void initializeClass(){
        gameStatusService = new GameStatusService();
    }

//    @Test
//    void 입력문자열이_2이면_참을_반환(){
//        assertThat(gameStatusService.isEndOfGame("2")).isTrue();
//    }
//
//    @Test
//    void 스탑게임_하면_게임상태_거짓(){
//        gameStatusService.stopGame();
//        assertThat(gameStatusService.getGameStatus()).isFalse();
//    }
//
//    @Test
//    void 스탑게임_안하면_게임상태_참(){
//        assertThat(gameStatusService.getGameStatus()).isTrue();
//    }

    @Test
    void 입력이_2이면_게임상태_거짓으로_초기화(){
        gameStatusService.setGameStatus("2");
        assertThat(gameStatusService.getGameStatus()).isFalse();
    }

    @Test
    void 입력이_1이면_게임상태_참으로_유지(){
        gameStatusService.setGameStatus("1");
        assertThat(gameStatusService.getGameStatus()).isTrue();
    }
}
