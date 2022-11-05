package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest2 extends NsTest {
    @DisplayName("올바른 랜덤 값 생성")
    @Test
    void createTargetNums_test() {
        List<Integer> result = Application.createTargetNums();
        assertEquals(3, result.size());
        for(int element : result)
            assertThat(element).isBetween(1, 9);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
