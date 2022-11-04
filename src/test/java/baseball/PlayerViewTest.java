package baseball;

import baseball.view.PlayerView;
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
        playerView.readInput();
        assertThat(playerView.getInput()).isEqualTo(input);
    }

    @Test
    void 입력이_숫자가_없으면_있으면_예외처리(){
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->playerView.readInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 숫자여야 합니다. ");
    }

    @Test
    void 입력이_숫자가_네자리면_예외처리(){
        String input = "0123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->playerView.readInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값은 세 자리여야 합니다. ");
    }

    @Test
    void 입력이_숫자가_0이_있으면_예외처리(){
        String input = "012";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->playerView.readInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값에 0이 없어야 합니다. ");
    }

    @Test
    void 입력이_숫자가_같으면_예외처리(){
        String input = "112";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(()->playerView.readInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력한 값이 서로 다른 숫자여야 합니다. ");
    }
}
