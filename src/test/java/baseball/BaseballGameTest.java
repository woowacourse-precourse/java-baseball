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
    void checkUserNumber_메서드가_올바른_입력에_맞는_리스트_반환() {
        assertThat(game.checkUserNumber("123")).isEqualTo(List.of(1, 2, 3));
        assertThat(game.checkUserNumber("359")).isEqualTo(List.of(3, 5, 9));
    }

    @Test
    void checkUserNumber_메서드가_올바르지않은_입력에_예외_발생() {
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
        void printResult_메서드가_스트라이크_볼_출력() {
            System.out.println(computer.new GameResult(1, 2));
            assertThat(captor.toString().trim()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        void printResult_메서드가_스트라이크만_출력() {
            System.out.println(computer.new GameResult(3, 0));
            assertThat(captor.toString().trim()).isEqualTo("3스트라이크");
        }

        @Test
        void printResult_메서드가_볼만_출력() {
            System.out.println(computer.new GameResult(0, 2));
            assertThat(captor.toString().trim()).isEqualTo("2볼");
        }

        @Test
        void printResult_메서드가_낫싱_출력() {
            System.out.println(computer.new GameResult(0, 0));
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
        void nextTurn_메서드가_조건에_맞는_boolean_반환() {
            boolean next = game.nextTurn(computer. new GameResult(3, 0));
            assertThat(next).isEqualTo(false);
            next = game.nextTurn(computer. new GameResult(2, 1));
            assertThat(next).isEqualTo(true);
            next = game.nextTurn(computer. new GameResult(0, 0));
            assertThat(next).isEqualTo(true);
        }
    }

    @Test
    void checkUserAnswer_메서드가_올바른_입력에_맞는_정수_반환() {
        assertThat(game.checkUserAnswer("1")).isEqualTo(1);
        assertThat(game.checkUserAnswer("2")).isEqualTo(2);
    }

    @Test
    void checkUserAnswer_메서드가_올바르지않은_입력에_맞는_예외_발생() {
        assertThatThrownBy(() -> game.checkUserNumber("3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber(".")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("21")).isInstanceOf(IllegalArgumentException.class);
    }
}
