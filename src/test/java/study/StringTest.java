package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
        // 하나라도 포함이 되었으면 테스트 통과
    void split_메서드로_주어진_값을_구분_1() {
        String input = "1,,23";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
        // 정확하게 포함이 되었는가
    void split_메서드로_주어진_값을_구분_2() {
        String input = "1,,23";
        String[] result = input.split(",");

        assertThat(result).contains("1");

        // 정확하게 들어있는가
        assertThat(result).containsExactly("1", "", "23");
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
    void a_few_simple_assertions() {
        assertThat("The Lord of the Rings")
            // 널이 아니고
            .isNotNull()
            // The로 시작하고
            .startsWith("The")
            // Lord가 포함하고
            .contains("Lord")
            .contains("of")
            // 이중에 하나가 포함되었다.
            .containsAnyOf("the", "rings")
            // 끝이 Rings이다.
            .endsWith("Rings");
    }

    @Test
    void a_few_simple_assertions_2() {
        assertThat("123")
            // 널이 아니고
            .isNotNull()
            // The로 시작하고
            .startsWith("1")
            // Lord가 포함하고
            .contains("3")
            .contains("2")
            // 이중에 하나가 포함되었다.
            .containsAnyOf("1", "aslkdjasd", "아무단어")
            // 끝이 Rings이다.
            .endsWith("3");
    }

    class Human {

        final String name;
        int age;

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
    }

    @Test
    void filter_test() {
        List<Human> list = new ArrayList<>();
        Human kim = new Human("Kim", 22);
        Human park = new Human("Park", 25);
        Human lee = new Human("Lee", 22);
        Human amy = new Human("Amy", 25);
        Human jack = new Human("Jack", 22);
        Human anyName = new Human("Jack", 22);

        list.add(kim);
        list.add(park);
        list.add(lee);
        list.add(amy);
        list.add(jack);
        list.add(anyName);

        //  이름을 가져와서 a 가 포함되어 있는 객체들만 필터링을 하고 그 객체를 검증한다.
        assertThat(list).filteredOn(human -> human.getName().contains("a"))
            .containsOnly(jack, anyName, park);
    }

    @Test
    void filter_test2() {
        List<Human> list = new ArrayList<>();
        Human kim = new Human("Kim", 22);
        Human park = new Human("Park", 25);
        Human lee = new Human("Lee", 25);
        Human amy = new Human("Amy", 22);
        Human jack = new Human("Jack", 22);

        list.add(kim);
        list.add(park);
        list.add(lee);
        list.add(amy);
        list.add(jack);

        assertThat(list).filteredOn("age", 25).containsOnly(park, lee);
    }

    @Test
    void extraction_test() {
        List<Human> list = new ArrayList<>();
        Human kim = new Human("Kim", 22);
        Human park = new Human("Park", 25);
        Human lee = new Human("Lee", 25);

        list.add(kim);
        list.add(park);
        list.add(lee);
//        assertThat(list).extracting("name").contains("Kim", "Park", "Lee");
//        assertThat(list).extracting("age").contains(22, 25, 25);

        assertThat(list).extracting("name", "age")
            .contains(tuple("Kim", 22),
                tuple("Park", 25),
                tuple("Lee", 25)
            );
    }

    @Test
    void 문자열_검증() {
        String expression = "This is a string";
        assertThat(expression).startsWith("This").endsWith("string").contains("a");
    }

    @Test
    public void exception_assertion_example() {
        assertThatIOException().isThrownBy(() -> {
                throw new IOException("boom!");
            })
            .withMessage("%s!", "boom")
            .withMessageContaining("boom")
            .withNoCause();
    }

    @Test
    public void testException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
                throw new IllegalArgumentException("boom!");
            })
            .withMessage("%s!", "boom")
            .withMessageContaining("boom")
            .withNoCause();
    }

    @Test
    public void testExcasdeption() {
        assertThatCode(() -> {
            System.out.println("test");
        }).doesNotThrowAnyException();
    }


    @ParameterizedTest(name = "매개변수")
    @ValueSource(strings = {"1", "123"})
    void 파라미터_테스트_연습(String name) {
        assertThat(name).contains("1");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"1", "13"})
    void nullEmptyStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty()
            || Integer.parseInt(text) > 0 && Integer.parseInt(text) < 4);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(chars = {'a', 'a', 'a'})
    void char_테스트(char text) {
        assertThat(text).isEqualTo('a');
    }

    @ParameterizedTest
    //          value = 이넘의 이금 정의  names =  이넘의 값을 정의
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
    }
}
