package baseball;

import baseball.service.JudgeGame;
import baseball.util.ValidationUtil;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UnitTest extends NsTest {

    @Test
    void 세자리_수_입력값_적정성_검토() {

        String examNum1 = "1234";
        String examNum2 = "110";
        String examNum3 = "ktx";
        String examNum4 = "112";

        boolean return1 = ValidationUtil.validateInputNumber(examNum1);
        boolean return2 = ValidationUtil.validateInputNumber(examNum2);
        boolean return3 = ValidationUtil.validateInputNumber(examNum3);
        boolean return4 = ValidationUtil.validateInputNumber(examNum4);

        assertThat(return1).isEqualTo(false);
        assertThat(return2).isEqualTo(false);
        assertThat(return3).isEqualTo(false);
        assertThat(return4).isEqualTo(false);
    }

    void 세자리_수_입력값_적정성_검토_후_리스트_변환(){

        String inputNum = "123";
        List<String> answerList = new ArrayList<>();
        answerList.add("1");
        answerList.add("2");
        answerList.add("3");

        if (ValidationUtil.validateInputNumber(inputNum)){
            List<String> inputNumList = new ArrayList<>();
            inputNumList = JudgeGame.getInputNumberList(inputNum);
            assertThat(inputNumList).isEqualTo(answerList);
        }
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}