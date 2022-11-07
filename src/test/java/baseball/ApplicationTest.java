package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private Validations validations;
    private Processing processing ;
    @BeforeEach
    void getInstanceOfMethodClass(){
        this.validations = new Validations();
        this.processing = new Processing();
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
