package baseball;

import baseball.controller.GameController;
import baseball.view.SystemMessage;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {

    GameController gameController = new GameController();

    @Test
    void 볼_0개_확인() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(4, 5, 6);
        gameController.setGamerForTest(playerNumbers, computerNumbers);
        assertThat(gameController.getBallCount()).isEqualTo(0);
    }

    @Test
    void 볼_1개_확인() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(3, 2, 6);
        gameController.setGamerForTest(playerNumbers, computerNumbers);
        assertThat(gameController.getBallCount()).isEqualTo(1);
    }

    @Test
    void 볼_2개_확인() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(3, 2, 1);
        gameController.setGamerForTest(playerNumbers, computerNumbers);
        assertThat(gameController.getBallCount()).isEqualTo(2);
    }

    @Test
    void 볼_3개_확인() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(2, 3, 1);
        gameController.setGamerForTest(playerNumbers, computerNumbers);
        assertThat(gameController.getBallCount()).isEqualTo(3);
    }

    @Test
    void 스트라이크_0개_확인() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(2, 3, 1);
        gameController.setGamerForTest(playerNumbers, computerNumbers);
        assertThat(gameController.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void 스트라이크_1개_확인() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 3, 2);
        gameController.setGamerForTest(playerNumbers, computerNumbers);
        assertThat(gameController.getStrikeCount()).isEqualTo(1);
    }

    @Test
    void 스트라이크_2개_확인() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 4);
        gameController.setGamerForTest(playerNumbers, computerNumbers);
        assertThat(gameController.getStrikeCount()).isEqualTo(2);
    }

    @Test
    void 스트라이크_3개_확인() {
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> playerNumbers = Arrays.asList(1, 2, 3);
        gameController.setGamerForTest(playerNumbers, computerNumbers);
        assertThat(gameController.getStrikeCount()).isEqualTo(3);
    }

    @Test
    void 게임_재개_입력시_올바르게_처리하는지_확인() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(gameController.isResume()).isEqualTo(true);
    }

    @Test
    void 게임_종료_입력시_올바르게_처리하는지_확인() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(gameController.isResume()).isEqualTo(false);
    }

    @Test
    void 게임_재개와_종료가_아닌_값_입력시_예외처리() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> gameController.isResume())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SystemMessage.INPUT_IS_NOT_START_OR_STOP.getMessage());
    }
}
