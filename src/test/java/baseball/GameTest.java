package baseball;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {


    @Nested
    @DisplayName("중복이 아닌 숫자를 찾는 메소드")
    class GetRandomIntegerExcludeInList {


        @RepeatedTest(1000)
        @DisplayName("빈 리스트가 들어갔을 때")
        void listIsEmpty() throws Exception {
            //Given
            Game game = new Game();
            Method getRandomIntegerExcludeInList = Game.class.getDeclaredMethod("getRandomIntegerExcludeInList", List.class);
            getRandomIntegerExcludeInList.setAccessible(true);
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

            //When
            List<Integer> answer = List.of();
            int number = (int) getRandomIntegerExcludeInList.invoke(game, answer);

            //Then
            assertThat(numbers.contains(number)).isEqualTo(true);
        }

        @DisplayName("리스트가 1개 일떄")
        @RepeatedTest(1000)
        void listHasOneElement() throws Exception {
            //Given
            Game game = new Game();
            Method getRandomIntegerExcludeInList = Game.class.getDeclaredMethod("getRandomIntegerExcludeInList", List.class);
            getRandomIntegerExcludeInList.setAccessible(true);

            //When
            List<Integer> answer = List.of(1);
            int number = (int) getRandomIntegerExcludeInList.invoke(game, answer);

            //Then
            assertThat(number).isNotEqualTo(1);
        }
    }

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
            assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3스트라이크");
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

}