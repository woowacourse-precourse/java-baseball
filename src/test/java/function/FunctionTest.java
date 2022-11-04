package function;

import org.junit.jupiter.api.Test;

import java.util.*;
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

    @Test
    public void 심판_카운트_동작_확인() throws Exception {
        //case1 1스트라이크 1볼
        //given
        List<Integer> input1 = List.of(2,5,3);
        List<Integer> answer1 = List.of(2,3,8);
        //when
        Map<String, Integer> result1 = createRefereeCount(input1,answer1);
        //then
        assertThat(result1.get("strike")).isEqualTo(1);
        assertThat(result1.get("ball")).isEqualTo(1);

        //case2 낫싱
        //given
        List<Integer> input2 = List.of(8,5,2);
        List<Integer> answer2 = List.of(3,4,9);
        //when
        Map<String, Integer> result2 = createRefereeCount(input2,answer2);

        //then
        assertThat(result2.get("ball")).isEqualTo(0);
        assertThat(result2.get("strike")).isEqualTo(0);

        //case3 3볼
        //given
        List<Integer> input3 = List.of(8,5,2);
        List<Integer> answer3 = List.of(5,2,8);
        //when
        Map<String, Integer> result3 = createRefereeCount(input3,answer3);

        //then
        assertThat(result3.get("ball")).isEqualTo(3);
    }

}
