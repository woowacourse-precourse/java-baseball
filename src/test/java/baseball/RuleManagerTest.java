package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RuleManagerTest extends NsTest {

    @Test
    @DisplayName("스트라이크가 몇개인지 확인하는 테스트")
    void strikeTest() {
        List<Long> lists = new ArrayList<>();
        lists.add(1L);
        lists.add(2L);
        lists.add(3L);
        assertThat(3).isEqualTo(RuleManager.countStrike(new User("123"), lists));
    }

    @Test
    @DisplayName("볼이 몇개인지 확인하는 테스트")
    void ballTest() {
        List<Long> lists = new ArrayList<>();
        lists.add(2L);
        lists.add(3L);
        lists.add(1L);
        assertThat(3).isEqualTo(RuleManager.countBall(new User("123"), lists));
    }

    @Override
    protected void runMain() {

    }
}
