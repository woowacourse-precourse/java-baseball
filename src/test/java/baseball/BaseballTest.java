package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.condition.Negative;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest extends NsTest {

    @Test
    void 랜덤_생성_테스트(){
        List<Integer> computers = Application.generateRandNum();
        assertThat(computers.size()).isEqualTo(3);

    }

    @ParameterizedTest
    @MethodSource("generateParsingData")
    void 파싱_테스트(final String s, final List<Integer> ans){
        List<Integer> user = Application.parseString(s);
        assertThat(ans.equals(user));
    }

    static Stream<Arguments> generateParsingData() {
        return Stream.of(
                Arguments.of("123", Arrays.asList(1, 2, 3)),
                Arguments.of("1", Arrays.asList(1)),
                Arguments.of("1234", Arrays.asList(1, 2, 3, 4)),
                Arguments.of("asd", Arrays.asList('a'-'0', 's'-'0', 'd'-'0'))
        );
    }

    @ParameterizedTest
    @MethodSource("generateCompareData")
    void 컴퓨터_유저_숫자_비교_테스트(final List<Integer> user, final List<Integer> computer, final List<Integer> res){
        List<Integer> test_res = Application.compareNums(user, computer);
        assertThat(res.equals(test_res));
    }

    static Stream<Arguments> generateCompareData(){
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), Arrays.asList(0, 3)),
                Arguments.of(Arrays.asList(1, 2, 4), Arrays.asList(1, 2, 3), Arrays.asList(0, 2)),
                Arguments.of(Arrays.asList(3, 1, 2), Arrays.asList(1, 2, 3), Arrays.asList(3, 0)),
                Arguments.of(Arrays.asList(3, 2, 1), Arrays.asList(1, 2, 3), Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(4, 5, 6), Arrays.asList(1, 2, 3), Arrays.asList(0, 0))
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
