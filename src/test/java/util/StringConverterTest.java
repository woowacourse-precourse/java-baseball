package util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.util.StringConverter.stringToIntList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class StringConverterTest {

    @Test
    void 숫자로된_문자열이_List_로_잘변환되는지_확인() {
        final String input = "123";
        
        assertInstanceOf(List.class, stringToIntList(input));
        assertEquals(input.length(), stringToIntList(input).size());
    }
}
