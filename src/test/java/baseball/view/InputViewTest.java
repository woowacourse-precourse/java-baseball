package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputView Class")
@DisplayNameGeneration(ReplaceUnderscores.class)
class InputViewTest {

    private InputView inputView;

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    static Stream<Arguments> readLineProvider() {
        return Stream.of(arguments("2", "24", "1234"));
    }

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    public void 숫자_입력_받기() {

        //given
        InputStream readLine = setReadLine("926");
        System.setIn(readLine);

        //when
        String expect = "926";
        String actual = inputView.putReadLine();

        //then
        assertEquals(expect, actual);
    }

    @ParameterizedTest
    @MethodSource("readLineProvider")
    public void 범위를_벗어난_수_입력(String readLine) {
        //given
        System.setIn(setReadLine(readLine));

        //then
        Assertions.assertThatThrownBy(() -> inputView.validate(readLine))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "228", "399"})
    public void 중복_입력(String readLine) {
        //given
        System.setIn(setReadLine(readLine));

        //then
        Assertions.assertThatThrownBy(() -> inputView.validate(readLine))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"abc", "ABC", "!@#"})
    public void 숫자가_아닌_입력(String readLine) {
        //given
        System.setIn(setReadLine(readLine));

        //then
        Assertions.assertThatThrownBy(() -> inputView.validate(readLine))
                .isInstanceOf(IllegalArgumentException.class);
    }
}