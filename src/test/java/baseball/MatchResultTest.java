package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;


class MatchResultTest {

    @Test
    void print() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        new MatchResult(0,3).print();
        Assertions.assertThat(out.toString()).isEqualTo("3스트라이크"+System.lineSeparator());
        out.reset();

        new MatchResult(1,2).print();
        Assertions.assertThat(out.toString()).isEqualTo("1볼 2스트라이크"+System.lineSeparator());
        out.reset();

        new MatchResult(3,0).print();
        Assertions.assertThat(out.toString()).isEqualTo("3볼"+System.lineSeparator());
        out.reset();

        new MatchResult(0,0).print();
        Assertions.assertThat(out.toString()).isEqualTo("낫싱"+System.lineSeparator());
        out.reset();
    }

    @Test
    void isCorrect() {
        Assertions.assertThat(new MatchResult(0,3).isCorrect()).isEqualTo(true);
        Assertions.assertThat(new MatchResult(1,2).isCorrect()).isEqualTo(false);
    }
}