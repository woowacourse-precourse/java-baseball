package baseball.game;

import static org.assertj.core.api.Assertions.*;

import baseball.board.NumberBoardConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    BaseballGame baseballGame;
    private final ByteArrayOutputStream outputPrint = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputPrint));
        baseballGame = new BaseballGame(List.of(4, 2, 5));
    }

    @Test
    void play_메소드는_성공시_성공_메시지와_종료메시지를_출력() {
        System.setIn(new ByteArrayInputStream("425".getBytes()));
        baseballGame.play();
        assertThat(outputPrint.toString().contains(BaseballConstants.INPUT_MESSAGE)).isEqualTo(true);
        assertThat(outputPrint.toString().contains(BaseballConstants.SUCCESS_MESSAGE)).isEqualTo(true);
        assertThat(outputPrint.toString().contains(BaseballConstants.END_MESSAGE)).isEqualTo(true);
    }

    @Test
    void play_메소드는_시작_메시지를_출력하지_않음() {
        System.setIn(new ByteArrayInputStream("425".getBytes()));
        baseballGame.play();
        assertThat(outputPrint.toString().contains(BaseballConstants.START_MESSAGE)).isEqualTo(false);
    }

    @Test
    void play_메소드는_비교_결과를_출력() {
        System.setIn(new ByteArrayInputStream("425".getBytes()));
        baseballGame.play();
        assertThat(outputPrint.toString().contains("3스트라이크")).isEqualTo(true);
    }

    @Test
    void play_메소드는_실패시_성공_메시지를_출력하지_앉음() {
        System.setIn(new ByteArrayInputStream("426".getBytes()));
        assertThatThrownBy(() -> baseballGame.play())
                .hasMessageContaining("No line found");
        assertThat(outputPrint.toString().contains(BaseballConstants.SUCCESS_MESSAGE)).isEqualTo(false);
    }

    @Test
    void play_메소드는_모든_수가_틀릴시_NOT_MATCH_AT_ALL_MESSAGE_메시지를_출력() {
        System.setIn(new ByteArrayInputStream("789".getBytes()));
        assertThatThrownBy(() -> baseballGame.play())
                .hasMessageContaining("No line found");
        assertThat(outputPrint.toString().contains(NumberBoardConstant.NOT_MATCH_AT_ALL_MESSAGE)).isEqualTo(true);
    }
}
