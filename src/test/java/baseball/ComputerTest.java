package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest extends NsTest {
    @Test
    @DisplayName("랜덤숫자 생성 확인")
    void randomTest() {
        List<Long> test = Computer.makeRandomNumber();
        assertThat(3).isEqualTo(test.size());
    }

    @Override
    protected void runMain() {

    }
}
