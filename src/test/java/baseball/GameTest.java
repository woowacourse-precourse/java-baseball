package baseball;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    @Nested
    @DisplayName("예측한 답에 대한 결과 출력")
    class GetGameResultOfJudge {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @Test
        @DisplayName("낫싱일때")
        void nothing() throws Exception {
            //Given
            Game game = new Game();
            List<Integer> judge = List.of(0, 0);

            //When
            boolean gameResultOfJudge = game.getGameResultOfJudge(judge);

            //Then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("낫싱");
            assertThat(gameResultOfJudge).isFalse();
        }

        @Test
        @DisplayName("게임이 종료될 때")
        void gameEnd() throws Exception {
            //Given
            Game game = new Game();
            List<Integer> judge = List.of(0, 3);

            //When
            boolean gameResultOfJudge = game.getGameResultOfJudge(judge);

            //Then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            assertThat(gameResultOfJudge).isTrue();
        }

        @Test
        @DisplayName("볼만 있을 때")
        void onlyBall() throws Exception {
            //Given
            Game game = new Game();
            List<Integer> judge = List.of(2, 0);

            //When
            boolean gameResultOfJudge = game.getGameResultOfJudge(judge);

            //Then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼");
            assertThat(gameResultOfJudge).isFalse();
        }

        @Test
        @DisplayName("스트라이크만 있을 때")
        void onlyStrike() throws Exception {
            //Given
            Game game = new Game();
            List<Integer> judge = List.of(0, 2);

            //When
            boolean gameResultOfJudge = game.getGameResultOfJudge(judge);

            //Then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2스트라이크");
            assertThat(gameResultOfJudge).isFalse();
        }

        @Test
        @DisplayName("둘다 있을 때")
        void mixed() throws Exception {
            //Given
            Game game = new Game();
            List<Integer> judge = List.of(2, 1);

            //When
            boolean gameResultOfJudge = game.getGameResultOfJudge(judge);

            //Then
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼 1스트라이크");
            assertThat(gameResultOfJudge).isFalse();
        }
    }

    @Nested
    @DisplayName("게임을 다시 할것인지")
    class IsPlayingNewGame {
        @Test
        @DisplayName("게임을 다시 시작")
        void restart() throws Exception {
            //Given
            Game game = new Game();
            ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
            System.setIn(in);

            //When
            boolean playingNewGame = game.isPlayingNewGame();

            //Then
            assertThat(playingNewGame).isTrue();
        }

        @Test
        @DisplayName("게임을 종료함")
        void gameEnd() throws Exception {
            //Given
            Game game = new Game();
            ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
            System.setIn(in);

            //When
            boolean playingNewGame = game.isPlayingNewGame();

            //Then
            assertThat(playingNewGame).isFalse();
        }

        @Test
        @DisplayName("잘못된 선택")
        void illegalChoice() throws Exception {
            //Given
            Game game = new Game();
            ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
            System.setIn(in);

            //When
            //Then
            assertThatThrownBy(() -> game.isPlayingNewGame())
                    .isInstanceOf(IllegalArgumentException.class);

        }
    }
}