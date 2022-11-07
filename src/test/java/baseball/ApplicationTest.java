package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void getRandomNum_format() {
        //given
        //when
        List<Integer> result = Application.getRandomNum();
        //then
        //3자리 숫자인지
        assertThat(result.size()).isEqualTo(3);
        //모두 1~9사이의 숫자인지
        assertThat(result.stream().allMatch(x -> x >= 1 && x <= 9)).isTrue();
    }

    // parseUserInput 함수에 올바른 형식의 숫자 문자열이 들어갔을 때 올바른 숫자 리스트가 나오는지
    @Test
    void parseUserInput_correct() {
        //given
        String iptCorrect[] = {
                "123",
                "789",
                "147",
                "139",
                "952"
        };

        List<List<Integer>> optCorrect = List.of(
                List.of(1, 2, 3),
                List.of(7, 8, 9),
                List.of(1, 4, 7),
                List.of(1, 3, 9),
                List.of(9, 5, 2)
        );
        //when
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < iptCorrect.length; i++) {
            result.add(Application.parseUserInput(iptCorrect[i]));
        }
        //then
        for (int i = 0; i < iptCorrect.length; i++) {
            assertThat(result).isEqualTo(optCorrect);
        }
    }

    //parseUserInput 함수에 올바르지 못한 형식의 입력이 들어갔을 때 IllegalArgumentException예외가 던져지는지
    @Test
    void parseUserInput_illegal() {
        //given
        final String iptIllegal[] = {
                //길이가 길거나 짧음
                "",
                "1",
                "12",
                "1234",
                //자릿수가 중복되는 숫자 존재
                "111",
                "122",
                "212",
                "221",
                //0이 존재하는 경우
                "012",
                "301",
                "310"
        };

        //when & then
        for (String ipt : iptIllegal) {
            assertThatThrownBy(() -> Application.parseUserInput(ipt)).
                    isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void getStrikeCnt() {
        //given
        List<List<Integer>> A = List.of(
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6)
        );
        List<List<Integer>> B = List.of(
                //3strike
                List.of(1, 3, 6),
                //2strike
                List.of(1, 3, 8),
                List.of(1, 7, 6),
                List.of(2, 3, 6),
                //1strike
                List.of(1, 6, 3),
                List.of(6, 3, 1),
                List.of(2, 4, 6),
                //0strike
                List.of(3, 6, 1)
        );
        List<Integer> expected = List.of(
                3,
                2,
                2,
                2,
                1,
                1,
                1,
                0
        );
        //when
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            result.add(Application.getStrikeCnt(A.get(i), B.get(i)));
        }

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getBallCnt() {
        //given
        List<List<Integer>> A = List.of(
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6),
                List.of(1, 3, 6)
        );
        List<List<Integer>> B = List.of(
                //0Ball
                List.of(1, 3, 6),
                List.of(1, 7, 6),
                List.of(1, 3, 8),
                List.of(2, 3, 6),
                List.of(2, 4, 6),
                //1Ball
                List.of(2, 6, 4),
                List.of(2, 1, 6),
                List.of(6, 4, 2),
                //2Ball
                List.of(6, 3, 1),
                List.of(1, 6, 3),
                List.of(3, 6, 8),
                //3Ball
                List.of(6, 1, 3),
                List.of(3, 6, 1)

        );
        List<Integer> expected = List.of(
                0,
                0,
                0,
                0,
                0,
                1,
                1,
                1,
                2,
                2,
                2,
                3,
                3
        );
        //when
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            result.add(Application.getBallCnt(A.get(i), B.get(i)));
        }

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
