package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    BaseballGame game;
    String selectedNumbers;
    String result;

    @BeforeEach
    void init() {
        game = new BaseballGame(List.of(1,2,3));
    }

    @Test
    void 입력숫자길이가_3개초과면_예외() {
        selectedNumbers = "1234";
        assertThatThrownBy(() -> game.playGame(selectedNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력숫자길이가_3개미만이면_예외() {
        selectedNumbers = "12";
        assertThatThrownBy(() -> game.playGame(selectedNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력숫자가_같은숫자가포함이면_예외() {
        selectedNumbers = "111";
        assertThatThrownBy(() -> game.playGame(selectedNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임진행_쓰리스트라이크() {
        selectedNumbers = "123";
        result = "3스트라이크";
        GameBoard gameBoard = game.playGame(selectedNumbers);
        assertThat(gameBoard.getResult()).isEqualTo(result);
    }

    @Test
    void 게임진행_아웃() {
        selectedNumbers = "456";
        result = "낫싱";
        GameBoard gameBoard = game.playGame(selectedNumbers);
        assertThat(gameBoard.getResult()).isEqualTo(result);
    }

    @Test
    void 게임진행_1볼() {
        selectedNumbers = "451";
        result = "1볼 ";
        GameBoard gameBoard = game.playGame(selectedNumbers);
        assertThat(gameBoard.getResult()).isEqualTo(result);
    }
}
