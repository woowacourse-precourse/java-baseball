package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.io.*;


public class PlayerViewTest {

    PlayerView playerView;

    @BeforeEach
    void initializeClass(){
        playerView = new PlayerView();
    }

    @Test
    void 입력_문자열이_정상반환_되는지(){
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = playerView.getPlayerOpinion();
        assertThat(result).isEqualTo(input);
    }

    @Test
    void 입력이_숫자가_없으면_있으면_예외처리(){
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->playerView.getPlayerOpinion())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.");
    }

    @Test
    void 입력이_숫자가_네자리면_예외처리(){
        String input = "0123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->playerView.getPlayerOpinion())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.");
    }

    @Test
    void 입력이_숫자가_0이_있으면_예외처리(){
        String input = "012";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->playerView.getPlayerOpinion())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.");
    }

    @Test
    void 입력이_숫자가_같으면_예외처리(){
        String input = "112";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->playerView.getPlayerOpinion())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다.");
    }
}
