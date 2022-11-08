package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameMachineTest {
    GameMachine gameMachine = new GameMachine();

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    void 중복되는_숫자가_없는_길이가_3인_integer_list_생성한다() {
        // When
        List<Integer> integerList = gameMachine.generateThreeDiffDigit();

        int size = integerList.size();
        long distinctIntegerListSize = integerList.stream().distinct().count();

        // Then
        assertThat(size).isEqualTo(3);
        assertThat(distinctIntegerListSize).isEqualTo(3);
    }

    @Test
    void gamer에게_입력받은_문자열을_integer_list_로_반환한다() {
        // Given
        Gamer gamer = new Gamer();
        String input = "123";
        command(input);

        // When
        List<Integer> threeDiffDigit = gameMachine.askInputThreeDiffDigit(gamer);

        // Then
        List<Integer> integerList = List.of(1, 2, 3);
        assertThat(threeDiffDigit).isEqualTo(integerList);
    }

    @Nested
    @DisplayName("gamer_의_입력값으로_ball_인지_strike인지_판별하고_game의_ball_count_를_업데이트한다")
    class BallCountUpdateTest {
        @Test
        void 볼_0개_스트라이크_0개() {
            // Given
            Game game = new Game();
            game.setThreeDiffDigit(List.of(1, 3, 5));

            List<Integer> threeDiffDigitOfGamer = List.of(2, 4, 6);

            // When
            gameMachine.updateBallCount(threeDiffDigitOfGamer, game);
            String ballCount = game.getBallCount();

            // Then
            String result = "낫싱";
            assertThat(ballCount).isEqualTo(result);
        }
        @Test
        void 볼_0개_스트라이크_2개() {
            // Given
            Game game = new Game();
            game.setThreeDiffDigit(List.of(1, 3, 5));

            List<Integer> threeDiffDigitOfGamer = List.of(1, 3, 4);

            // When
            gameMachine.updateBallCount(threeDiffDigitOfGamer, game);
            String ballCount = game.getBallCount();

            // Then
            String result = "2스트라이크";
            assertThat(ballCount).isEqualTo(result);
        }
        @Test
        void 볼_1개_스트라이크_1개() {
            // Given
            Game game = new Game();
            game.setThreeDiffDigit(List.of(1, 3, 5));

            List<Integer> threeDiffDigitOfGamer = List.of(1, 2, 3);

            // When
            gameMachine.updateBallCount(threeDiffDigitOfGamer, game);
            String ballCount = game.getBallCount();

            // Then
            String result = "1볼 1스트라이크";
            assertThat(ballCount).isEqualTo(result);
        }
    }

    @Nested
    @DisplayName("gamer에게_입력받은_값이")
    class ReplayAskTest {
        @Test
        void replay_값이면_true를_반환하고() {
            // Given
            Gamer gamer = new Gamer();
            String input = "1";
            command(input);

            // When
            boolean playFlag = gameMachine.askReplay(gamer);

            // Then
            boolean result = true;
            assertThat(playFlag).isEqualTo(result);
        }
        @Test
        void quit_값이면_false를_반환한다() {
            // Given
            Gamer gamer = new Gamer();
            String input = "2";
            command(input);

            // When
            boolean playFlag = gameMachine.askReplay(gamer);

            // Then
            boolean result = false;
            assertThat(playFlag).isEqualTo(result);
        }
    }

}
