package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private Validations validations;
    private Processing processing ;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void getInstanceOfMethodClass(){
        this.validations = new Validations();
        this.processing = new Processing();
        // 별도 출력 테스트를 하지 않을 경우엔 주석 처리하고 실행
//        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        // 별도 출력 테스트를 하지 않을 경우엔 주석 처리하고 실행
//        System.setOut(originalOut);
    }

    @Test
    void 입력값_Validation_Test(){
        // given
        String inputNum = "4234";

        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validations.isCorrectInput(inputNum))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 입력값_Return_Test(){
        // given
        ArrayList<String> answer = new ArrayList<>(){{ add("4");add("2");add("3");}};

        // then
        // readLine 메서드 특성상 테스트 시점에만 해당 메서드에 고정 값 지정 후 테스트 진행
        assertThat(answer).isEqualTo(processing.askInputNumber());
    }

    @Test
    void 낫싱_Check_Test(){
        // given
        ArrayList<String> answer = new ArrayList<>(){{ add("4");add("2");add("3");}};
        ArrayList<String> userNumList = new ArrayList<>(){{ add("1");add("9");add("7");}};

        // when
        boolean isNothing = validations.checkIsItNothing(answer, userNumList);

        //then
        assertThat(isNothing).isTrue();
    }

    @Test
    void Strike_Count_Test(){
        // given
        ArrayList<String> answer = new ArrayList<>(){{ add("4"); add("2"); add("3");}} ;
        ArrayList<String> userNumList = new ArrayList<>(){{ add("2"); add("9"); add("3");}}  ;

        // when
        ArrayList<String> containedNumList = processing.findContainedNumbers(answer, userNumList);
        int containedNumCnt = processing.countContained(containedNumList);
        int strikeCnt = processing.countStrike(answer, containedNumList);
        int ballCnt = processing.countBall(containedNumCnt, strikeCnt);

        // then
        assertThat(containedNumCnt).isEqualTo(2);
        assertThat(strikeCnt).isEqualTo(1);
        assertThat(ballCnt).isEqualTo(1);
    }

    @Test
    void Ball_Print_Test(){
        // given
        int ballCount = 2;

        // when
        processing.printBall(ballCount);

        //then
        assertThat("2볼 ").isEqualTo(outContent.toString());
    }

    @Test
    void StrikeAndBall_Print_Test(){
        // given
        int ballCount = 2;
        int strikeCount = 1;

        // when
        processing.printBall(ballCount);
        processing.printStrike(strikeCount);

        //then
        assertThat("2볼 1스트라이크\n").isEqualTo(outContent.toString());
    }
    @Test
    void StrikeZero_Print_Test(){
        // given
        int ballCount = 2;
        int strikeCount = 0;

        // when
        processing.printBall(ballCount);
        processing.printStrike(strikeCount);

        //then
        assertThat("2볼 \n").isEqualTo(outContent.toString());
    }

    @Test
    void 통합_연산_Test(){
        // given
        ArrayList<String> answer = new ArrayList<>(){{ add("4"); add("2"); add("3");}} ;
        ArrayList<String> containedNumList = new ArrayList<>(){{ add("-1"); add("9"); add("3");}}  ;
        Map<String, Object> resultMap = new HashMap<>(){{
                put("strikeCount",1);
                put("ballCount",1);
                put("isStrikeThree",false);
        }};

        // when
        Map<String,Object> testMap = processing.calculateStrikeAndBall(answer,containedNumList);

        // then
        assertThat(testMap).isEqualTo(resultMap);
        assertThat(testMap.get("strikeCount")).isEqualTo(1);
        assertThat(testMap.get("ballCount")).isEqualTo(1);
        assertThat(testMap.get("isStrikeThree")).isEqualTo(false);
    }

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

    @Override
    public void runMain() {
        main(new String[]{});
    }
}
