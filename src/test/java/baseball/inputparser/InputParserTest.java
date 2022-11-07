package baseball.inputparser;

import org.junit.jupiter.api.Test;
import java.util.List;

import static baseball.inputparser.InputParser.parseInGameInput;
import static baseball.inputparser.InputParser.parseRestartInput;
import static baseball.inputparser.RestartType.RESTART;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * InputParser 클래스와 관련된 테스트 클래스입니다.
 * @version 1.0.0
 * @author CHO MinHo
 */
class InputParserTest {

    /**
     * 게임 도중의 input에 대해서 서로 다른 3개의 숫자를 가진 input인지를 정상적으로 판단하는지에 대한 테스트입니다.
     */
    @Test
    void parseInGameInputTest() {
        // Case 1. 정상 케이스
        List<Integer> integerList = parseInGameInput("123");
        assertThat(integerList.size()).isEqualTo(3);

        // Case 2. 비정상 케이스 - 숫자로 파싱되지 않는 경우
        assertThatThrownBy(() -> parseInGameInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 서로 다른 숫자를 입력해야 합니다! ex)123");

        // Case 3. 비정상 케이스 - 3개의 숫자가 아닌 경우
        assertThatThrownBy(() -> parseInGameInput("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 서로 다른 숫자를 입력해야 합니다! ex)123");

        // Case 4. 비정상 케이스 - 서로 다른 숫자가 아닌 경우
        assertThatThrownBy(() -> parseInGameInput("112"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 서로 다른 숫자를 입력해야 합니다! ex)123");
    }

    /**
     * 게임이 끝난 시점의 input에 대해서 1 또는 2를 가진 input인지를 정상적으로 판단하는지에 대한 테스트입니다.
     */
    @Test
    void parseRestartInputTest() {
        // Case 1. 정상 케이스
        RestartType restartType = parseRestartInput("1");
        assertThat(restartType).isEqualTo(RESTART);

        // Case 2. 비정상 케이스 - 숫자로 파싱되지 않는 경우
        assertThatThrownBy(() -> parseRestartInput("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 2의 숫자를 입력해야 합니다! ex)1");

        // Case 3. 비정상 케이스 - 1 또는 2가 아닌 경우
        assertThatThrownBy(() -> parseRestartInput("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 2의 숫자를 입력해야 합니다! ex)1");
    }

}