package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    @DisplayName("이름 표시 연습 테스트")
    void nameExpressionTest() {

    }

    @RepeatedTest(5)
    @DisplayName("반복 테스트 연습")
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition() + " / "
                + repetitionInfo.getTotalRepetitions());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("매개변수 테스트 연습")
    void parameterizedTest(int input) {
        System.out.println(input);
    }

    @Test
    @DisplayName("assertThat 기본 테스트 연습")
    void assertThatBasicTest() {
        String string = "Woowa Tech Course";

        assertThat(string)
                .isNotNull()
                .isNotEmpty()
                .startsWith("Woowa")
                .endsWith("Course")
                .contains("Tech")
                .isEqualTo("Woowa Tech Course")
                .isNotEqualTo("abcd");
    }

    public class ExampleClass {

        public String string;

        public ExampleClass(String string) {
            this.string = string;
        }
    }

    @Test
    @DisplayName("동일성, 동등성 비교 연습")
    void instanceCompareTest() {
        ExampleClass ec1 = new ExampleClass("ex");
        ExampleClass ec2 = new ExampleClass("ex");

        // assertThat(ec1).isEqualTo(ec2); //fail. 동일성 비교
        assertThat(ec1).usingRecursiveComparison().isEqualTo(ec2); //success. 동등성 비교
    }

    @Test
    @DisplayName("Map 관련 테스트 연습")
    void aboutMapTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        assertThat(map)
                .containsKey("a")
                .containsValue(1)
                .containsEntry("a", 1)
                .contains(entry("a", 1), entry("b", 2));
    }

    @Test
    @DisplayName("예외처리 관련 테스트 연습")
    void exampleTest() {
        assertThatThrownBy(() -> {
            List<String> list = new ArrayList<>(List.of("a", "b"));
            list.get(2);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    List<String> list = new ArrayList<>(List.of("a", "b"));
                    list.get(2);
                });

        Throwable thrown = catchThrowable(() -> {
            List<String> list = new ArrayList<>(List.of("a", "b"));
            list.get(2);
        });

        assertThat(thrown)
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

}
