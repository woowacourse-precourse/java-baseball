package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.Objects;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {
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
        Application.main(new String[]{});
    }

    @Test
    void computerMakeRandomNumber() {
        //given
        Computer computer = new Computer();
        int cnt = 0;

        //when
        List<Integer> computerNumbers = computer.makeComputerNumbers();

        for (int i = 1; i < computerNumbers.size(); i++) {
            if (Objects.equals(computerNumbers.get(i - 1), computerNumbers.get(i))) {
                cnt++;
            }
        }

        //then
        Assertions.assertThat(cnt).isEqualTo(0);
    }

    @Test
    void validUserInputOverLap() {
        //given
        User user = new User();
        String userInput = "111";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validUserInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("이미 입력한 숫자는 입력할수 없습니다.");
    }

    @Test
    void validUserInputZero() {
        //given
        User user = new User();
        String userInput = "012";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validUserInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("0은 입력할수 없습니다.");
    }

    @Test
    void validUserInputSpace() {
        //given
        User user = new User();
        String userInput = "  1";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validUserInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("공백은 입력할수 없습니다.");
    }

    @Test
    void validUserInputLengthOver() {
        //given
        User user = new User();
        String userInput = "1234";

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.validUserInput(userInput);
        });

        String message = exception.getMessage();

        //then
        assertThat(message).isEqualTo("숫자는 세자리 수만 입력 가능합니다.");
    }

    @Test
    void validUserInputOk() {
        //given
        User user = new User();
        String userInput = "123";

        //when
        String validUserInput = user.validUserInput(userInput);

        //then
        assertThat(validUserInput).isEqualTo(userInput);
    }

}
