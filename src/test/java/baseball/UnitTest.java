package baseball;

import baseball.util.ValidationUtil;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}