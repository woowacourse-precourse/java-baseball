package baseball;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballUtilTest {
    private static BaseballUtil baseballUtil;
    @BeforeAll
    static void initAll(){
        baseballUtil = new BaseballUtil();
    }

    @DisplayName("올바르지 않은 입력값(ㅁㄴㅇㄹ)에 대한 처리")
    @Test
    public void readLineInt_takeString_throwIllegalArgumentException() {
        String input = "ㅁㄴㅇㄹ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            baseballUtil.readLineInt();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 입력값(123)에 대한 처리")
    @Test
    public void readLineInt_takeInt() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int value = baseballUtil.readLineInt();

        assertThat(value).isEqualTo(123);
    }
}
