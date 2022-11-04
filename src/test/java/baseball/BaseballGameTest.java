package baseball;

import com.sun.jdi.ByteType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {

    BaseballGame game;

    @BeforeEach
    public void beforeEach() {
        game = new BaseballGame();
    }

    @Test
    void check_user_number_test() {
        assertThat(game.checkUserNumber("123")).isEqualTo(List.of(1, 2, 3));
        assertThat(game.checkUserNumber("359")).isEqualTo(List.of(3, 5, 9));
        assertThatThrownBy(() -> game.checkUserNumber("3456")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("61")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("ab2")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("224")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("204")).isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class BaseballGamePrintTest {
        OutputStream captor;
        PrintStream standardOut = System.out;
        Computer computer;

        @BeforeEach
        public void beforeEach() {
            captor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captor));
            computer = new Computer();
        }

        @AfterEach
        public void afterEach() {
            System.setOut(standardOut);
        }

        @Test
        void print_result_strike_and_ball_test() {
            game.printResult(computer.new GameResult(1, 2));
            assertThat(captor.toString().trim()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        void print_result_only_strike_test() {
            game.printResult(computer.new GameResult(3, 0));
            assertThat(captor.toString().trim()).isEqualTo("3스트라이크");
        }

        @Test
        void print_result_only_ball_test() {
            game.printResult(computer.new GameResult(0, 2));
            assertThat(captor.toString().trim()).isEqualTo("2볼");
        }

        @Test
        void print_result_nothing_test() {
            game.printResult(computer.new GameResult(0, 0));
            assertThat(captor.toString().trim()).isEqualTo("낫싱");
        }

    }

    @Nested
    class BaseballGameLoopTest {
        Computer computer;

        @BeforeEach
        public void BeforeEach() {
            computer = new Computer();
        }

        @Test
        void next_turn_test() {
            boolean next = game.nextTurn(computer. new GameResult(3, 0));
            assertThat(next).isEqualTo(false);
            next = game.nextTurn(computer. new GameResult(2, 1));
            assertThat(next).isEqualTo(true);
            next = game.nextTurn(computer. new GameResult(0, 0));
            assertThat(next).isEqualTo(true);
        }
    }

}
