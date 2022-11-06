package baseball;

import baseball.gameComponents.MainFunctions;
import baseball.gameComponents.SubUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class convertStringToListTest {
    private SubUtils subUtils = new SubUtils();
    @Test
    void 전환_테스트() {
        //given
        String input = "0011";
        //when
        List<Integer> actual = subUtils.convertStringToList(input);
        //then
        assertThat(actual)
                .isInstanceOf(List.class)
                .isEqualTo(List.of(0, 0, 1, 1));
    }
}
