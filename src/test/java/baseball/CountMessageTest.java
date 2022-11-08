package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CountMessageTest extends NsTest {
    CountMessage countMessage = new CountMessage();

    @Test
    void 스트라이크_메세지() {
        countMessage.message(2, 0);
        assertThat(output()).contains("스트라이크");
    }

    @Test
    void 볼_메세지() {
        countMessage.message(0, 2);
        assertThat(output()).contains("볼");
    }

    @Test
    void 낫싱_메세지() {
        countMessage.message(0, 0);
        assertThat(output()).contains("낫싱");
    }

    @Override
    protected void runMain() {

    }
}