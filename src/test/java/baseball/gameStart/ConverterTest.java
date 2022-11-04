package baseball.gameStart;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.utils.Converter;

public class ConverterTest {

    @ParameterizedTest
    @CsvSource({"0,2,2스트라이크", "0,0,낫싱", "2,0,2볼", "2,2,2볼 2스트라이크"})
    void resultMap_to_string_test(Integer ball, Integer strike, String expect) {
        Map<String, Integer> input = new HashMap<>() {{
            put("ball", ball);
            put("strike", strike);
        }};

        String result = Converter.changeResultMapToString(input);
        Assertions.assertThat(result).isEqualTo(expect);
    }
}
