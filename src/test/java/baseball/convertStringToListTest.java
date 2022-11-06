package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

public class convertStringToListTest {
    @Test
    void 전환_테스트() {
        //given
        String input = "0011";
        //when
        List<Integer> actual = convertStringToList(input);
        //then
        assertThat(actual)
                .isInstanceOf(List.class)
                .isEqualTo(List.of(0, 0, 1, 1));
    }


    List<Integer> convertStringToList(String input) {
        List<Integer> list = Arrays.asList(input.split("")).stream()
                .mapToInt(str -> Integer.parseInt(str))
                .boxed()
                .collect(Collectors.toList());
        return list;
    }
}
