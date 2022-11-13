package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.Application.createThreeNumbers;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 컴퓨터가 1에서 9까지 서로다른 임의의 수 3개를 선택하는 메서드에 대한 테스트
    @Test
    void 컴퓨터가_선택한_수가_null이_아닌지_테스트() {
        List<String> threeNumber = Application.createThreeNumbers();
        assertNotNull(threeNumber);
    }

    @Test
    void 컴퓨터가_선택한_수가_3개인지_테스트() {
        List<String> threeNumber = Application.createThreeNumbers();
        assertEquals(3, threeNumber.size());
    }

    @Test
    void 컴퓨터가_선택한_수가_1부터_9까지의_범위를_벗어나는지_테스트() {
        List<String> threeNumber = Application.createThreeNumbers();
        for (int index = 0; index < threeNumber.size(); index++) {
            int oneNumber = Integer.valueOf(threeNumber.get(index));
            assertTrue(1 <= oneNumber && 9 >= oneNumber);
        }
    }

    // 게임플레이어로부터 입력받은 3자리 숫자에 대한 예외처리 메서드 테스트
    @Test
    void 유저로부터_입력받은_숫자는_3자리의_숫자() {
        Boolean threeNumber = Application.checkValidForInputThreeNumber("1432");
        assertTrue(!threeNumber);
    }

    @Test
    void 유저로부터_입력받은_값에_숫자가_아닌_것이_존재하는지에_대한_예외처리() {
        Boolean threeNumber = Application.checkValidForInputThreeNumber("2fd");
        assertTrue(!threeNumber);
        threeNumber = Application.checkValidForInputThreeNumber("ㄹㄴ1");
        assertTrue(!threeNumber);
        threeNumber = Application.checkValidForInputThreeNumber("@#*");
        assertTrue(!threeNumber);
    }

    @Test
    void 유저로부터_입력받은_숫자에_입력범위를_벗어나는_숫자가_포함된_경우에_대한_예외처리() {
        Boolean threeNumber = Application.checkValidForInputThreeNumber("025");
        assertTrue(!threeNumber);
        threeNumber = Application.checkValidForInputThreeNumber("043");
        assertTrue(!threeNumber);
    }

    // 스트라이크 수를 세는 메서드에 대한 테스트
    @Test
    void 스트라이크수를_계산하는_메서드_1스트라이크가_계산되어야_하는_경우() {
        List<String> computersNumber = Arrays.asList("9", "1", "4");
        String userNumber = "963";

        int strikesNumber = Application.calculateTheNumberOfStrikes(computersNumber, userNumber);
        assertEquals(1, strikesNumber);
    }

    @Test
    void 스트라이크수를_계산하는_메서드_2스트라이크가_계산되어야_하는_경우() {
        List<String> computersNumber = Arrays.asList("9", "1", "4");
        String userNumber = "917";

        int strikesNumber = Application.calculateTheNumberOfStrikes(computersNumber, userNumber);
        assertEquals(2, strikesNumber);
    }

    @Test
    void 스트라이크수를_계산하는_메서드_3스트라이크가_계산되어야_하는_경우() {
        List<String> computersNumber = Arrays.asList("5", "2", "9");
        String userNumber = "529";

        int strikesNumber = Application.calculateTheNumberOfStrikes(computersNumber, userNumber);
        assertEquals(3, strikesNumber);
    }

    @Test
    void 스트라이크수를_계산하는_메서드_0스트라이크가_계산되어야_하는_경우() {
        List<String> computersNumber = Arrays.asList("5", "2", "9");
        String userNumber = "312";

        int strikesNumber = Application.calculateTheNumberOfStrikes(computersNumber, userNumber);
        assertEquals(0, strikesNumber);
    }

    // 볼 수를 세는 메서드에 대한 테스트
    @Test
    void 볼_수를_계산하는_메서드_1볼이_계산되어야_하는_경우() {
        List<String> computersNumber = Arrays.asList("9", "1", "4");
        String userNumber = "123";

        int ballsNumber = Application.calculateTheNumberOfBalls(computersNumber, userNumber);
        assertEquals(1, ballsNumber);
    }

    @Test
    void 볼_수를_계산하는_메서드_2볼이_계산되어야_하는_경우() {
        List<String> computersNumber = Arrays.asList("9", "1", "4");
        String userNumber = "145";

        int ballsNumber = Application.calculateTheNumberOfBalls(computersNumber, userNumber);
        assertEquals(2, ballsNumber);
    }

    @Test
    void 볼_수를_계산하는_메서드_3볼이_계산되어야_하는_경우() {
        List<String> computersNumber = Arrays.asList("5", "2", "9");
        String userNumber = "952";

        int ballsNumber = Application.calculateTheNumberOfBalls(computersNumber, userNumber);
        assertEquals(3, ballsNumber);
    }

    @Test
    void 볼_수를_계산하는_메서드_0볼이_계산되어야_하는_경우() {
        List<String> computersNumber = Arrays.asList("5", "2", "9");
        String userNumber = "173";

        int ballsNumber = Application.calculateTheNumberOfBalls(computersNumber, userNumber);
        assertEquals(0, ballsNumber);
    }

    // 입력한 숫자에 대한 결과를 출력하는 메서드에 대한 테스트
    @Test
    void 입력한_숫자에_대한_결과를_계산하는_메서드_3스트라이크() {
        List<String> computersNumber = Arrays.asList("5", "2", "9");
        String userNumber = "529";
        int strikeNumber = Application.calculateTheNumberOfStrikes(computersNumber, userNumber);
        int ballNumber = Application.calculateTheNumberOfBalls(computersNumber, userNumber);
        Application.outputFinalResultAndWhetherAllMatches(strikeNumber, ballNumber);
        assertEquals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", output());
    }

    @Test
    void 입력한_숫자에_대한_결과를_계산하는_메서드_2볼_1스트라이크() {
        List<String> computersNumber = Arrays.asList("5", "2", "9");
        String userNumber = "592";
        int strikeNumber = Application.calculateTheNumberOfStrikes(computersNumber, userNumber);
        int ballNumber = Application.calculateTheNumberOfBalls(computersNumber, userNumber);
        Application.outputFinalResultAndWhetherAllMatches(strikeNumber, ballNumber);
        assertEquals("2볼 1스트라이크", output());
    }

    @Test
    void 입력한_숫자에_대한_결과를_계산하는_메서드_3볼() {
        List<String> computersNumber = Arrays.asList("5", "2", "9");
        String userNumber = "295";
        int strikeNumber = Application.calculateTheNumberOfStrikes(computersNumber, userNumber);
        int ballNumber = Application.calculateTheNumberOfBalls(computersNumber, userNumber);
        Application.outputFinalResultAndWhetherAllMatches(strikeNumber, ballNumber);
        assertEquals("3볼", output());
    }

    @Test
    void 입력한_숫자에_대한_결과를_계산하는_메서드_낫싱() {
        List<String> computersNumber = Arrays.asList("5", "2", "9");
        String userNumber = "163";
        int strikeNumber = Application.calculateTheNumberOfStrikes(computersNumber, userNumber);
        int ballNumber = Application.calculateTheNumberOfBalls(computersNumber, userNumber);
        Application.outputFinalResultAndWhetherAllMatches(strikeNumber, ballNumber);
        assertEquals("낫싱", output());
    }

    // 게임플레이어로 부터 입력받은 새로운 게임을 시작할지 여부에 대한 숫자 예외처리
    @Test
    void 새로운게임시작여부에_대한_입력_값_예외처리메서드() {
        assertTrue(Application.checkValidForInputWhetherReplay("1"));
        assertTrue(Application.checkValidForInputWhetherReplay("2"));
        assertTrue(!Application.checkValidForInputWhetherReplay("2231"));
        assertTrue(!Application.checkValidForInputWhetherReplay("0"));
        assertTrue(!Application.checkValidForInputWhetherReplay("sjfjd"));
        assertTrue(!Application.checkValidForInputWhetherReplay("ㅁㅇㄹㄴ"));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
