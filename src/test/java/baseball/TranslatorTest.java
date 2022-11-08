package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TranslatorTest {

    @Test
    void 문자열을_정수로_변환_성공_테스트() {
        String input = "123";
        assertDoesNotThrow(() -> Translator.translateStringToIntegerList(input));
    }
}