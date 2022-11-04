package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BaseBallGameInputTest {

    private static final InputStream systemIn = System.in;
    private static BaseBallGame baseBallGame;

    @BeforeAll
    static void setUp() {
        baseBallGame = new BaseBallGame(new Computer());
        assertThat(baseBallGame).isNotNull();
    }

    @Test
    void 정상_입력_테스트() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatCode(() -> baseBallGame.start())
                .doesNotThrowAnyException();
    }

    @Test
    void 길이가_3이하인_입력() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> baseBallGame.start())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이가_3보다_큰_입력() {
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> baseBallGame.start())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_입력() {
        String input = "a1b";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> baseBallGame.start())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_숫자_입력() {
        String input = "121";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> baseBallGame.start())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
    }
}
