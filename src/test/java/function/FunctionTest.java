package function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.Application.*;
import static org.assertj.core.api.Assertions.*;

public class FunctionTest {

    @Test
    public void 입력_데이터_예외처리() throws Exception {
        //given
        /**
         * 3자리 이상 숫자, 중복숫자, 1~9 이외의 문자
         */
        String[] inputs = {"1234","223","한글","012"};

        //when then
        for (String input : inputs) {
            assertThatThrownBy(() -> validateAnswer(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }
    @Test
    public void 입력값_리스트_생성() throws Exception {
        //given
        String input = "543";

        //when
        List<Integer> list = createInputNumberList(input);

        //then
        assertThat(list).isEqualTo(List.of(5,4,3));
    }

    @Test
    public void 정답_리스트_사이즈_확인() throws Exception {
        //given

        //when
        List<Integer> baseballList = createBaseballNumberList();
        Set<Integer> distinct = new HashSet<>(baseballList);

        // then
        assertThat(baseballList.size()).isEqualTo(3);
        assertThat(distinct.size()).isEqualTo(3);

    }
}
