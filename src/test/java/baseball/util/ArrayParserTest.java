package baseball.util;

import static org.assertj.core.api.Assertions.*;

import baseball.utils.ArrayParser;

import org.junit.jupiter.api.Test;


public class ArrayParserTest {

    @Test
    void caseStringToCharList(){
        String input = "abc";
        assertThat(ArrayParser.stringToCharList(input)).contains('a','b','c');
    }

    @Test
    void caseStringToIntegerList(){
        String input = "123";
        assertThat(ArrayParser.stringToIntegerList(input)).contains(1,2,3);
    }
}
