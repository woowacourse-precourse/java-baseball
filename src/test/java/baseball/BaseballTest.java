package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

import static baseball.Application.*;


class BaseballTest {
    @DisplayName("안내문구 출력하기")
    @ParameterizedTest(name = "{index} {displayName} userNumber={0} ")
    @ValueSource(strings = {"456", "123"})
    void getGuideMessage_현재_userNumber_상태에_따른_메시지_반환(String input) {
        String result = getGuideMessage(input);
        assertThat(result).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Test
    @DisplayName("안내문구 출력하기 (null)")
    void getGuideMessage_현재_userNumber_상태에_따른_메시지_반환2() {
        String input = null;
        String result = getGuideMessage(input);
        assertThat(result).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    @DisplayName("사용자 숫자 입력받기")
    void getUserNumber_입력받은_사용자_숫자_반환() {
        String input = "123\n";

        /*
         * camp.nextstep.edu.missionutils.Console의 readLine() 참고하여
         * Sacnner의 nextLine() 사용함을 확인
         * 사용자의 입력에 대한 예상 리턴값인지 확인
         */

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        assertThat(scanner.nextLine()).isEqualTo("123");
    }

    @DisplayName("사용자 숫자 자릿수(길이) 확인")
    @ParameterizedTest(name = "{index} {displayName} userNumber={0} result={1}")
    @CsvSource({"'123',true", "'5',false", "'1234',false", "'',false"})
    void checkNumberLength_userNumber_길이에_따른_boolean_반환(String input, boolean result) {
        assertThat(checkNumberLength(input)).isEqualTo(result);
    }

    @DisplayName("문자열이 숫자로만 이루어져 있는지 확인")
    @ParameterizedTest(name = "{index} {displayName} userNumber={0} result={1}")
    @CsvSource({"'123',true", "'!12',false", "'1234a',false", "'',false"})
    void checkOnlyNumber_userNumber_숫자로만_이루어져_있는지_확인(String input, boolean result) {
        assertThat(checkOnlyNumber(input)).isEqualTo(result);
    }

    @DisplayName("문자열에 0이 없는지 확인")
    @ParameterizedTest(name = "{index} {displayName} userNumber={0} result={1}")
    @CsvSource({"'123',true", "'105',false", "'012',false", "'120',false"})
    void checkNotContainZero_userNumber_0이_없는지_확인(String input, boolean result) {
        assertThat(checkNotContainZero(input)).isEqualTo(result);
    }

    @DisplayName("문자열에 중복문자가 없는지 확인")
    @ParameterizedTest(name = "{index} {displayName} userNumber={0} result={1} ")
    @CsvSource({"'123',true", "'100',false", "'252',false", "'322',false"})
    void checkNotDuplication_userNumber_중복이_없는지_확인(String input, boolean result) {
        assertThat(checkNotDuplication(input)).isEqualTo(result);
    }

}