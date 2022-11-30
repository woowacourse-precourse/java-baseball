//package baseball.testcase;
//
//import baseball.controller.GameController;
//import baseball.decision.Decision;
//import baseball.decision.DecisionMaker;
//import baseball.game.Game;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class GameControllerTest {
//    @Mock
//    DecisionMaker decisionMaker;
//
//    @Mock
//    Game game;
//
//    @InjectMocks
//    GameController gameController;
//
//    @BeforeEach
//    void init() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @DisplayName("야구 게임을 3번 반복한다")
//    @Test
//    void 야구게임_3번_반복() {
//        when(decisionMaker.getDecision())
//                .thenReturn(Decision.PLAY)
//                .thenReturn(Decision.PLAY)
//                .thenReturn(Decision.STOP);
//        gameController.playRecurringGame();
//
//        assertThat(gameController.getTimesOfPlayGame()).isEqualTo(3);
//    }
//
//    @DisplayName("Game 객체에서 에러 발생 가정")
//    @Test
//    void Game_객체에서_발생한_에러는_GameController의_에러로_전파된다() {
//        when(game.play())
//                .thenThrow(new IllegalArgumentException("잘못된 인자 값 입력입니다."));
//
//        assertThatThrownBy(() -> gameController.playRecurringGame())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("DecisionMaker 객체에서 에러 발생 가정")
//    @Test
//    void DecisionMaker_객체에서_발생한_에러는_GameController의_에러로_전파된다() {
//        when(decisionMaker.getDecision())
//                .thenThrow(new IllegalArgumentException("잘못된 인자 값 입력입니다."));
//
//        assertThatThrownBy(() -> gameController.playRecurringGame())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//}
