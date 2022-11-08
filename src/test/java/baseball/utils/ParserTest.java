package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    Parser parser = new Parser();

    @Test
    void parsePlayerNumbersTest() {
        String input = "123";
        List<Integer> result = Arrays.asList(1, 2, 3);
        assertThat(parser.parsePlayerNumbers(input)).isEqualTo(result);
    }

    @Test
    void parseIntTest() {
        String input = "1";
        Integer result = 1;
        assertThat(parser.parseInt(input)).isInstanceOf(Integer.class);
        assertThat(parser.parseInt(input)).isEqualTo(result);
    }
}