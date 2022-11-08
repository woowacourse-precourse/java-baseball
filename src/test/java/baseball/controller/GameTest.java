package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class GameTest {
    List<Integer> testTargetNumberList = new ArrayList<>(Arrays.asList(1, 2, 3));

    @Nested
    @DisplayName("게임이 진행 상태인지 확인")
    class checkIsGameStatusInProgress {

        @Test
        @DisplayName("진행 상태")
        void 진행상태() {
            Game game = new Game(testTargetNumberList);
            assertThat(game.checkIsGameStatusInProgress()).isEqualTo(true);
        }

        @Test
        @DisplayName("종료 상태")
        void 종료상태() {
            Game game = new Game(testTargetNumberList);
            game.setResultGameEnd();
            assertThat(game.checkIsGameStatusInProgress()).isEqualTo(false);
        }
    }

    @Nested
    @DisplayName("유저의 게임 반복 여부 확인을 위해, 입력이 1인지 확인")
    class checkIsOne {

        @Test
        @DisplayName("입력이 1인 경우 -> true 반환")
        void 입력이_1인_경우() {
            Game game = new Game(testTargetNumberList);
            assertThat(game.checkIsOne("1")).isEqualTo(true);
        }

        @Test
        @DisplayName("입력이 2인 경우 -> false 반환")
        void 입력이_2인_경우() {
            Game game = new Game(testTargetNumberList);
            assertThat(game.checkIsOne("2")).isEqualTo(false);
        }
    }

    @DisplayName("게임을 진행 상태로 수정")
    @Test
    void setResultGameInProgress() {
        Game game = new Game(testTargetNumberList);
        game.setResultGameEnd();
        game.setResultGameInProgress();
        assertThat(game.checkIsGameStatusInProgress()).isEqualTo(true);
    }

    @DisplayName("게임을 종료 상태로 수정")
    @Test
    void setResultGameEnd() {
        Game game = new Game(testTargetNumberList);
        game.setResultGameEnd();
        assertThat(game.checkIsGameStatusInProgress()).isEqualTo(false);
    }

}
