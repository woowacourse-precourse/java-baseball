package baseball.game;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static baseball.constant.Rule.END;
import static baseball.constant.Rule.PICK;
import static baseball.constant.Rule.START;
import static baseball.constant.Want.FINISH;
import static baseball.constant.Want.MORE;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StaffTest extends NsTest {
    Staff staff = new Staff();

    @Test
    void 목표값_생성() {
        List<Integer> targetNumbers = staff.getTargetNumbers();
        assertThat(targetNumbers.size()).isEqualTo(PICK.getValue());
        assertThat(new HashSet<>(targetNumbers).size()).isEqualTo(PICK.getValue());
    }

    @Test
    void 유저_입력값_생성() {
        List<Integer> userNumbers = staff.getUserNumbers("123");
        assertThat(userNumbers.size()).isEqualTo(PICK.getValue());
        assertThat(new HashSet<>(userNumbers).size()).isEqualTo(PICK.getValue());
    }

    @Test
    void 유저_입력값_길이미만() {
        Throwable exception = assertThrows(RuntimeException.class, () -> staff.getUserNumbers("12"));
        assertEquals("입력값이 " + PICK + "자리가 아닙니다.", exception.getMessage());
    }

    @Test
    void 유저_입력값_길이초과() {
        Throwable exception = assertThrows(RuntimeException.class, () -> staff.getUserNumbers("1234"));
        assertEquals("입력값이 " + PICK + "자리가 아닙니다.", exception.getMessage());
    }

    @Test
    void 유저_입력값_null() {
        Throwable exception = assertThrows(RuntimeException.class, () -> staff.getUserNumbers(null));
        assertEquals("입력값은 NULL일 수 없습니다.", exception.getMessage());
    }

    @Test
    void 유저_입력값_0입력() {
        Throwable exception = assertThrows(RuntimeException.class, () -> staff.getUserNumbers("012"));
        assertEquals("허용되지 않은 문자가 포함되어 있습니다. "
                + START + "부터 " + END + "까지의 값을 "
                + PICK + "번 사용해주세요", exception.getMessage());
    }

    @Test
    void 유저_입력값_문자열() {
        Throwable exception = assertThrows(RuntimeException.class, () -> staff.getUserNumbers("-12"));
        assertEquals("허용되지 않은 문자가 포함되어 있습니다. "
                + START + "부터 " + END + "까지의 값을 "
                + PICK + "번 사용해주세요", exception.getMessage());
    }

    @Test
    void 유저_입력값_중복() {
        Throwable exception = assertThrows(RuntimeException.class, () -> staff.getUserNumbers("112"));
        assertEquals("중복된 숫자가 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    void 유저_선택_재실행() {
        boolean userWantMore = staff.isUserWantFinish("1");
        assertThat(userWantMore).isFalse();
    }

    @Test
    void 유저_선택_중지() {
        boolean userWantFinish = staff.isUserWantFinish("2");
        assertThat(userWantFinish).isTrue();
    }

    @Test
    void 유저_선택_예외() {
        Throwable exception = assertThrows(RuntimeException.class, () -> staff.isUserWantFinish("3"));
        assertEquals(MORE + " 또는 " + FINISH + "의 값이 아닙니다.", exception.getMessage());
    }

    @Test
    void 유저_선택_null() {
        Throwable exception = assertThrows(RuntimeException.class, () -> staff.isUserWantFinish(null));
        assertEquals(MORE + " 또는 " + FINISH + "의 값이 아닙니다.", exception.getMessage());
    }

    @Override
    protected void runMain() {

    }
}