package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartTest {

    Start startGame = new Start();


    @Test
    void 길이가_3인_정답_생성() {
        int result = 3;
        assertThat(startGame.getCorrectAnswer().size()).isEqualTo(result);
    }

}