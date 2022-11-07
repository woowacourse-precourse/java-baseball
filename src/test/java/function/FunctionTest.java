package function;

import org.junit.jupiter.api.Test;

import java.util.*;

import static baseball.Computer.createBaseballNumberList;
import static baseball.Player.createInputNumberList;
import static baseball.Referee.createRefereeCount;
import static baseball.Referee.refereeAnswer;
import static baseball.ValidationCode.*;
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

    @Test
    public void 결과_메세지_반환() throws Exception {
        //case 1
        //given
        Integer ballCount1 = 2;
        Integer strikeCount1 = 2;
        //when
        String message1 = refereeAnswer(ballCount1, strikeCount1);
        //then
        assertThat(message1).isEqualTo("2볼 2스트라이크");

        //case 2
        //given
        Integer ballCount2 = 1;
        Integer strikeCount2 = 0;
        //when
        String message2 = refereeAnswer(ballCount2, strikeCount2);
        //then
        assertThat(message2).isEqualTo("1볼");

        //case 3
        //given
        Integer ballCount3 = 0;
        Integer strikeCount3 = 3;
        //when
        String message3 = refereeAnswer(ballCount3, strikeCount3);
        //then
        assertThat(message3).isEqualTo("3스트라이크");

        //case 4
        //given
        Integer ballCount4 = 0;
        Integer strikeCount4 = 0;
        //when
        String message4 = refereeAnswer(ballCount4, strikeCount4);
        //then
        assertThat(message4).isEqualTo("낫싱");

    }
    @Test
    public void 게임_종료_값_예외처리() throws Exception {
        //given
        /**
         * 1 or 2 이외의 모든 문자
         */
        String[] inputs = {"12","종료"," ","end"};

        //when then
        for (String input : inputs) {
            assertThatThrownBy(() -> validateFlag(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
