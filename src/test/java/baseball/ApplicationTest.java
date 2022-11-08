package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 길이가_초과한_값_입력_테스트() {
        String input = "1234";
        boolean result = false;
        assertThat(User.isNumberValidMaxSize(input)).isEqualTo(result);
    }

    @Test
    void 중복된_수_입력_테스트() {
        String input = "112";
        boolean result = false;
        assertThat(User.isNumberValidUnique(input)).isEqualTo(result);
    }

    @Test
    void 숫자가_아닌_값_입력_테스트() {
        String input = "1a2";
        boolean result = false;
        assertThat(User.isNumberValidRange(input)).isEqualTo(result);
    }

    @Test
    void 유효하지_않은_범위_내의_값_입력_테스트() {
        String input = "102";
        boolean result = false;
        assertThat(User.isNumberValidRange(input)).isEqualTo(result);
    }

    @Test
    void 입력값_숫자_변환_테스트() {
        String input = "123";
        List<Integer> result = List.of(1, 2, 3);
        assertThat(User.convertInputAsNumber(input)).isEqualTo(result);
    }

    @Test
    void 유효하지_않은_재시작_여부값_입력_테스트() {
        String flag = "a";
        boolean result = true;
        assertThat(User.isInValidFlag(flag)).isEqualTo(result);
    }

    @Test
    void 유효한_재시작_여부값_입력_테스트() {
        String flag = "1";
        boolean result = false;
        assertThat(User.isInValidFlag(flag)).isEqualTo(result);
    }

    @Test
    void 스트라이크_개수_셈_테스트() {
        List<Integer> answerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 2, 3);
        int result = 2;
        assertThat(Comparison.countStrikeNumbers(userNumber, answerNumber)).isEqualTo(result);
    }

    @Test
    void 스트라이크_판단_여부_실패_테스트() {
        List<Integer> answerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 2, 3);
        int index = 0;
        boolean result = false;
        assertThat(Comparison.isStrike(userNumber, answerNumber, index)).isEqualTo(result);
    }

    @Test
    void 스트라이크_판단_여부_성공_테스트() {
        List<Integer> answerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 2, 3);
        int index = 1;
        boolean result = true;
        assertThat(Comparison.isStrike(userNumber, answerNumber, index)).isEqualTo(result);
    }

    @Test
    void 볼_개수_셈_테스트() {
        List<Integer> answerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(2, 3, 1);
        int result = 3;
        assertThat(Comparison.countBallNumbers(userNumber, answerNumber)).isEqualTo(result);
    }

    @Test
    void 볼_판단_여부_실패_테스트() {
        List<Integer> answerNumber = List.of(1, 2, 3);
        Integer number = 2;
        int index = 1;
        boolean result = false;
        assertThat(Comparison.isBall(answerNumber, number, index)).isEqualTo(result);
    }

    @Test
    void 볼_판단_여부_성공_테스트() {
        List<Integer> answerNumber = List.of(1, 2, 3);
        Integer number = 2;
        int index = 0;
        boolean result = true;
        assertThat(Comparison.isBall(answerNumber, number, index)).isEqualTo(result);
    }

    @Test
    void 낫싱_판단_여부_실패_테스트() {
        int ballCount = 0;
        int strikeCount = 1;
        boolean result = false;
        assertThat(Comparison.isNothing(ballCount, strikeCount)).isEqualTo(result);
    }

    @Test
    void 낫싱_판단_여부_성공_테스트() {
        int ballCount = 0;
        int strikeCount = 0;
        boolean result = true;
        assertThat(Comparison.isNothing(ballCount, strikeCount)).isEqualTo(result);
    }

    @Test
    void 정답_판별_여부_실패_테스트() {
        List<Integer> answerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(4, 2, 3);
        boolean result = false;
        assertThat(Comparison.isAnswered(userNumber, answerNumber)).isEqualTo(result);
    }

    @Test
    void 정답_판별_여부_성공_테스트() {
        List<Integer> answerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 2, 3);
        boolean result = true;
        assertThat(Comparison.isAnswered(userNumber, answerNumber)).isEqualTo(result);
    }

    @Test
    void 낫싱_메세지_출력_테스트() {
        int ballCount = 0;
        int strikeCount = 0;
        String result = "낫싱";
        assertThat(Information.createComparisonMessage(ballCount, strikeCount)).isEqualTo(result);
    }

    @Test
    void 볼만_존재하는_메세지_출력_테스트() {
        int ballCount = 2;
        int strikeCount = 0;
        String result = "2볼";
        assertThat(Information.createComparisonMessage(ballCount, strikeCount)).isEqualTo(result);
    }

    @Test
    void 스트라이크만_존재하는_메세지_출력_테스트() {
        int ballCount = 0;
        int strikeCount = 2;
        String result = "2스트라이크";
        assertThat(Information.createComparisonMessage(ballCount, strikeCount)).isEqualTo(result);
    }

    @Test
    void 볼과_스트라이크가_존재하는_메세지_출력_테스트() {
        int ballCount = 1;
        int strikeCount = 2;
        String result = "1볼 2스트라이크";
        assertThat(Information.createComparisonMessage(ballCount, strikeCount)).isEqualTo(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
