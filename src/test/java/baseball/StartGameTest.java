package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StartGameTest {

    Game game = new Game();

    @Test
    void setComputerAnswer_메서드_호출시_3개의_서로_다른_수_생성_후_correctAnswer_변수에_반환() {
        game.setComputerAnswer();
        int result = 3;
        Set<Integer> set = new HashSet<>(game.correctAnswer);

        assertThat(game.correctAnswer.size()).isEqualTo(result);
        assertThat(game.correctAnswer.size()).isEqualTo(set.size());
    }

    @Test
    void getUserIntention_메서드_사용시_1이나_2가_입력되면_userIntention_변수에_저장() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        game.getUserIntention();

        assertThat(game.userIntention).isEqualTo(game.newGame);
    }


}