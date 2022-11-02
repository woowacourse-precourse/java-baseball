package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class SampleTest {
    @Test
    @DisplayName("두 변수는 동일")
    void 두_변수는_동일() {
        int num1 = 3;
        int num2 = 3;
        assertEquals(num1, num2);
    }

    @Test
    @DisplayName("두 변수는 다름")
    void 두_변수는_다름() {
        int num1 = 3;
        int num2 = 4;
        assertNotEquals(3, 4);
    }

    @Test
    @DisplayName("두 변수는 동일 객체를 참조")
    void 두_변수는_동일_객체를_참조() {
        String str1 = "abc";
        String str2 = str1;
        assertSame(str1, str2);
    }

    @Test
    @DisplayName("두 변수는 서로 다른 객체를 참조")
    void 두_변수는_서로_다른_객체를_참조() {
        String str1 = "abc";
        String str2 = "def";
        assertNotSame(str1, str2);
    }

    @Test
    @DisplayName("조건이 참임")
    void 조건이_참임() {
        assertTrue(3 < 5);
    }

    @Test
    @DisplayName("조건이 거짓임")
    void 조건이_거짓임() {
        assertFalse(3 > 5);
    }

    @Test
    @DisplayName("객체가 null임")
    void 객체가_null임() {
        String str = null;
        assertNull(str);
    }

    @Test
    @DisplayName("객체가 null이 아님")
    void 객체가_null이_아님() {
        String str = "abc";
        assertNotNull(str);
    }


    /* assertThat */
    @Test
    @DisplayName("assertThat - 두 변수는 동일")
    void assertThat_두_변수는_동일() {
        int num1 = 3;
        int num2 = 3;
        assertThat(num1).isEqualTo(num2);
    }

    @Test
    @DisplayName("assertThat - 두 변수는 다름")
    void assertThat_두_변수는_다름() {
        int num1 = 3;
        int num2 = 4;
        assertThat(num1).isNotEqualTo(num2);
    }

    @Test
    @DisplayName("assertThat - 두 변수는 동일 객체를 참조")
    void assertThat_두_변수는_동일_객체를_참조() {
        String str1 = "abc";
        String str2 = str1;
        assertThat(str1).isSameAs(str2);
    }

    @Test
    @DisplayName("assertThat - 두 변수는 서로 다른 객체를 참조")
    void assertThat_두_변수는_서로_다른_객체를_참조() {
        String str1 = "abc";
        String str2 = "def";
        assertThat(str1).isNotSameAs(str2);
    }

    @Test
    @DisplayName("assertThat - 조건이 참임")
    void assertThat_조건이_참임() {
        assertThat(3 < 5).isTrue();
        assertThat(3 > 5).isFalse();
    }

    @Test
    @DisplayName("assertThat - 객체가 null임")
    void assertThat_객체가_null임() {
        String str1 = null;
        String str2 = "abc";

        assertThat(str1).isNull();
        assertThat(str2).isNotNull();
    }

    @Test
    @DisplayName("assertThat - 리스트에 특정 요소가 존재")
    void assertThat_리스트에_특정_요소가_존재() {
        int[] arr = {1, 2, 3};
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        assertThat(arr).contains(3);
        assertThat(list)
                .contains("a")
                .contains("a","c")
                .doesNotContain("d")
                .containsExactly("a", "b", "c");

    }


    @Test
    @DisplayName("assertThat - list가 비어 있음")
    void assertThat_리스트가_비어있음() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list2.add("a");
        assertThat(list1).isEmpty();
        assertThat(list2).isNotEmpty();
    }

    @Test
    @DisplayName("assertThat - map이 특정 키를 포함")
    void assertThat_맵이_특정_키를_포함() {
        Map<String, String> map = new HashMap<>();

        map.put("name", "hansol");
        assertThat(map)
                .containsKey("name")
                .doesNotContainKey("age");

    }

    @Test
    @DisplayName("assertThat - 문자 검증")
    void assertThat_문자_검증() {
        assertThat('b')
                .inUnicode()
                .isLowerCase();

        assertThat("abc")
                .inUnicode()
                .isLowerCase()
                .startsWith("ab")
                .containsSequence("a", "b");
    }

    @Test
    @DisplayName("assertThat - 숫자 검증")
    void assertThat_숫자_검증() {
        assertThat(2)
                .isGreaterThan(1)
                .isLessThan(3)
                .isGreaterThanOrEqualTo(2)
                .isLessThanOrEqualTo(2);
    }

    @Test
    @DisplayName("assertThat - exception")
    void assertThat_exception(){
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
