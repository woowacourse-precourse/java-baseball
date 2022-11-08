package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {
    static String TEST_STRING = "test";
    static List<Character> TEST_STRING_TO_CHAR_LIST = List.of('t', 'e', 's', 't');

    @DisplayName("Utils: string으로 들어온 값을 character list/set으로 바꾸기")
    @Test
    void charConvert() {
        String input = TEST_STRING;
        List<Character> list = Utils.StringToCharList(input);
        HashSet<Character> set = Utils.StringToCharSet(input);
        List<Character> answerList = new ArrayList<>(TEST_STRING_TO_CHAR_LIST);
        HashSet<Character> answerSet = new HashSet<>(TEST_STRING_TO_CHAR_LIST);

        assertThat(list).isEqualTo(answerList);
        assertThat(set).isEqualTo(answerSet);
    }

    @DisplayName("Utils: map에 key로 들어온 값 하나 추가하기")
    @Test
    void addOneToMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(TEST_STRING, 1);
        map.put(TEST_STRING, 2);
        Utils.addOneToMap(map, TEST_STRING);
        assertThat(map).isEqualTo(map);
    }
}
