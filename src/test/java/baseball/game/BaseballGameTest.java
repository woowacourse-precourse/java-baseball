package baseball.game;

import baseball.numbers.InputNumbersGenerationStrategy;
import baseball.numbers.NumbersGenerationStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballGameTest {
    private OutputStream outputStream;

    @BeforeEach
    protected final void init() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 게임을_시작한다() {
        BaseballGame game = new BaseballGame(numbers(1, 2, 3));
        command("123", "2");

        game.start();

        assertThat(output()).contains("3스트라이크", "게임 종료");
    }

    @Test
    void 게임_종료_후_재시작한다() {
        BaseballGame game = new BaseballGame(numbers(List.of(1, 2, 3), List.of(7, 8, 9)));
        command("123", "1", "321", "786", "789", "2");

        game.start();

        assertThat(output()).contains("3스트라이크", "낫싱", "2스트라이크", "3스트라이크", "게임 종료");
    }

    @Test
    void 게임_종료_후_여러_번_재시작한다() {
        BaseballGame game = new BaseballGame(numbers(List.of(1, 2, 3), List.of(7, 8, 9), List.of(1, 4, 7)));
        command("123", "1", "321", "789", "1", "123", "427", "147", "2");

        game.start();

        List<String> expected = List.of("3스트라이크", "낫싱", "3스트라이크", "1스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        assertThat(output()).contains(expected);
    }

    @ValueSource(strings = {"111", "112", "122", "121", "1", "12", "1234", "가나다", "!#@"})
    @ParameterizedTest
    void 올바르지_않은_입력이_주어지면_예외가_발생한다(String input) {
        BaseballGame game = new BaseballGame(() -> List.of(1, 2, 3));
        command(input);

        assertThatThrownBy(game::start).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_종료_후_1또는_2가_아닌_값을_입력한다() {
        BaseballGame game = new BaseballGame(numbers(1, 2, 3));
        command("123", "3");

        assertThatThrownBy(game::start).isInstanceOf(IllegalArgumentException.class);
    }

    private void command(String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    private String output() {
        return outputStream.toString().trim();
    }

    private NumbersGenerationStrategy numbers(Integer... inputs) {
        return new InputNumbersGenerationStrategy(inputs);
    }

    private NumbersGenerationStrategy numbers(List<Integer>... inputs) {
        return new InputNumbersGenerationStrategy(inputs);
    }
}
