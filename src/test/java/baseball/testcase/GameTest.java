//package baseball.testcase;
//
//import baseball.game.Ball;
//import baseball.game.BallMaker;
//import baseball.game.BallReader;
//import baseball.game.Game;
//import baseball.game.ResultOfBall;
//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import java.util.EnumMap;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//
//public class GameTest extends NsTest {
//
//    @Mock
//    BallMaker ballMaker;
//
//    @Mock
//    BallReader ballReader;
//
//    @InjectMocks
//    Game game;
//
//    @BeforeEach
//    void mockSetting() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @DisplayName("BallReader가 게임이 끝났다 판단하면 Game은 종료돼야 한다.")
//    @Test
//    void BallReader_반환_값에_따른_게임_종료() {
//        //given
//        when(ballReader.isGameOver(any(), any()))
//                .thenReturn(false)
//                .thenReturn(true);
//
//        when(ballMaker.getRandomBall())
//                .thenReturn(new Ball(List.of(1, 2, 3)));
//
//        when(ballMaker.getUserBall())
//                .thenReturn(new Ball(List.of(2, 1, 3)));
//
//        when(ballReader.getStrikeAndBall(any(),any()))
//                .thenReturn(new EnumMap<>(ResultOfBall.class));
//
//        //when
//        game.play();
//
//        //then
//        assertThat(game.getNumberOfAttempts()).isEqualTo(2);
//    }
//
//    @DisplayName("BallReader에서 받은 결과 값에 따라 낫싱, 볼, 스트라이크 문자를 반환한다.")
//    @Test
//    void BallReader_반환_값에_따른_출력_검사() {
//        //given
//        when(ballReader.isGameOver(any(), any()))
//                .thenReturn(false)
//                .thenReturn(false)
//                .thenReturn(false)
//                .thenReturn(true);
//
//        when(ballMaker.getRandomBall())
//                .thenReturn(new Ball(List.of(1, 2, 3)));
//
//        when(ballMaker.getUserBall())
//                .thenReturn(new Ball(List.of(2, 1, 3)));
//
//        EnumMap<ResultOfBall, Integer> firstResult = new EnumMap<>(ResultOfBall.class);
//        firstResult.put(ResultOfBall.STRIKE, 2);
//
//        EnumMap<ResultOfBall, Integer> secondResult = new EnumMap<>(ResultOfBall.class);
//        secondResult.put(ResultOfBall.STRIKE, 1);
//        secondResult.put(ResultOfBall.BALL, 1);
//
//        EnumMap<ResultOfBall, Integer> thirdResult = new EnumMap<>(ResultOfBall.class);
//        thirdResult.put(ResultOfBall.BALL, 2);
//
//        EnumMap<ResultOfBall, Integer> fourthResult = new EnumMap<>(ResultOfBall.class);
//
//        when(ballReader.getStrikeAndBall(any(), any()))
//                .thenReturn(firstResult)
//                .thenReturn(secondResult)
//                .thenReturn(thirdResult)
//                .thenReturn(fourthResult);
//
//        //when
//        game.play();
//
//        //then
//        assertThat(output()).contains("2스트라이크", "1볼 1스트라이크", "2볼", "낫싱");
//    }
//
//    @DisplayName("BallMaker의 getRandomBall에서 예외가 나면 Game에도 예외가 전파된다")
//    @Test
//    void BallReader의_getRandomBall_에러_발생에_따른_게임_Game_에러_전파() {
//
//        when(ballMaker.getRandomBall())
//                .thenThrow(new IllegalArgumentException("RanddomeBall에서 예외발생"));
//
//        assertThatThrownBy(() -> game.play())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("BallMaker의 getUserBall에서 예외가 나면 Game에도 예외가 전파된다")
//    @Test
//    void BallReader의_getUserBall_예외_발생에_따른_게임_Game_예외_전파() {
//
//        when(ballMaker.getRandomBall())
//                .thenReturn(new Ball(List.of(1, 2, 3)));
//
//
//        when(ballMaker.getUserBall())
//                .thenThrow(new IllegalArgumentException("UserBall에서 예외발생"));
//
//        assertThatThrownBy(() -> game.play())
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Override
//    protected void runMain() {
//
//    }
//}
