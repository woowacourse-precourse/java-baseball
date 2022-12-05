package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    void 문자열을_정수형리스트로_변환() {
        List temp;
        temp = Converter.stringToList("327");
        System.out.println("temp = " + temp);
    }

    @Test
    void 정수형리스트_여부() {
        List temp;
        temp = Converter.stringToList("143");
        Assertions.assertThat(temp).isInstanceOf(List.class);
    }
}