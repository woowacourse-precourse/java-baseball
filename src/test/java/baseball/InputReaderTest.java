package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;


class InputReaderTest {

    @Test
    void readGameStatusTest() throws IOException {
        InputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Assertions.assertThat(InputReader.readGameStatus()).isEqualTo(true);

        in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        Assertions.assertThat(InputReader.readGameStatus()).isEqualTo(false);

        in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(InputReader::readGameStatus)
                .isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    void readNumber() {
        InputStream in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        Assertions.assertThat(InputReader.readNumber()).isEqualTo(new ArrayList<>(Arrays.asList("1", "2", "3")));

        in = new ByteArrayInputStream("abc".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(InputReader::readNumber)
                .isInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("1234".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(InputReader::readNumber)
                .isInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("111".getBytes());
        System.setIn(in);
        Assertions.assertThatThrownBy(InputReader::readNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}