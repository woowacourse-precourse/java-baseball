package baseball;
import baseball.view.GameStatusView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;
public class GameStatusViewTest {

    GameStatusView gameStatusView;

    @BeforeEach
    void initializeClass(){
        gameStatusView = new GameStatusView();
    }

    @Test
    void 입력이_1이나_2가_아니면_참을_반환(){
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        gameStatusView.readOpinion();
        assertThat(gameStatusView.isNotCorrectAnswer()).isTrue();
    }

    @Test
    void 입력시에_문자열로_저장해_문자열로_반환(){
        String input = "1";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        gameStatusView.readOpinion();
        assertThat(gameStatusView.getOpinion()).isEqualTo(input);
    }
}
