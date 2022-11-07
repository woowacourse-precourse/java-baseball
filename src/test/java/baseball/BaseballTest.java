package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

import static baseball.Application.*;


class BaseballTest {
    @DisplayName("안내문구 출력하기")
    @Test
    void getGuideMessage_현재_userStatus_상태에_따른_메시지_반환() {
        String input = "finished";
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
    @ParameterizedTest(name = "{index}. {displayName} userNumber={0} result={1}")
    @CsvSource({"'123',true", "'5',false", "'1234',false", "'',false"})
    void checkNumberLength_userNumber_길이에_따른_boolean_반환(String input, boolean result) {
        assertThat(checkNumberLength(input)).isEqualTo(result);
    }

    @DisplayName("문자열이 숫자로만 이루어져 있는지 확인")
    @ParameterizedTest(name = "{index}. {displayName} userNumber={0} result={1}")
    @CsvSource({"'123',true", "'!12',false", "'1234a',false", "'',false"})
    void checkOnlyNumber_userNumber_숫자로만_이루어져_있는지_확인(String input, boolean result) {
        assertThat(checkOnlyNumber(input)).isEqualTo(result);
    }

    @DisplayName("문자열에 0이 없는지 확인")
    @ParameterizedTest(name = "{index}. {displayName} userNumber={0} result={1}")
    @CsvSource({"'123',true", "'105',false", "'012',false", "'120',false"})
    void checkNotContainZero_userNumber_0이_없는지_확인(String input, boolean result) {
        assertThat(checkNotContainZero(input)).isEqualTo(result);
    }

    @DisplayName("문자열에 중복문자가 없는지 확인")
    @ParameterizedTest(name = "{index}. {displayName} userNumber={0} result={1} ")
    @CsvSource({"'123',true", "'100',false", "'252',false", "'322',false"})
    void checkNotDuplication_userNumber_중복이_없는지_확인(String input, boolean result) {
        assertThat(checkNotDuplication(input)).isEqualTo(result);
    }

    @DisplayName("userNumber 자릿수에 대한 예외처리 테스트")
    @ParameterizedTest(name = "{index}. {displayName} userNumber={0}")
    @ValueSource(strings = {"26", "1234"})
    void userNumber_길이에_따른_예외처리(String input) {
        assertThatThrownBy(() -> checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 세 자리 수가 아닙니다!");
    }

    @DisplayName("userNumber 문자 타입에 대한 예외처리 테스트")
    @ParameterizedTest(name = "{index}. {displayName} userNumber={0}")
    @ValueSource(strings = {"26a", "1i5"})
    void userNumber_타입에_대한_예외처리(String input) {
        assertThatThrownBy(() -> checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 숫자로만 이루어지지 않았습니다!");
    }

    @DisplayName("0 존재여부에 대한 예외처리 테스트")
    @ParameterizedTest(name = "{index}. {displayName} userNumber={0}")
    @ValueSource(strings = {"102", "059", "130"})
    void userNumber_0_존재여부에_대한_예외처리(String input) {
        assertThatThrownBy(() -> checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 0이 포함되어 있습니다!");
    }

    @DisplayName("중복 숫자 존재여부에 대한 예외처리 테스트")
    @ParameterizedTest(name = "{index}. {displayName} userNumber={0}")
    @ValueSource(strings = {"112", "311", "181"})
    void userNumber_중복_존재여부에_대한_예외처리(String input) {
        assertThatThrownBy(() -> checkIllegalArgumentException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 같은 수가 중복되었습니다!");
    }

    @DisplayName("checkIllegalArgumentException 정상 숫자인 경우 테스트")
    @Test
    void userNumber_정상인_경우_테스트() {
        String input = "126";
        assertThatCode(() -> checkIllegalArgumentException(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("ArrayList<Integer> 를 String 형으로 변환")
    @Test
    void convertArrayListToString_메서드로_ArrayList_String_변환() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1,2,3));
        assertThat(convertArrayListToString(input)).isEqualTo("123");
    }

    @DisplayName("generateComputerNumber 컴퓨터 숫자 생성 테스트")
    @Test
    void generateComputerNumber_정상_숫자인지_테스트() {
        String input = generateComputerNumber();
        assertThatCode(() -> checkIllegalArgumentException(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("String 을 ArrayList<Character> 로 변환")
    @Test
    void convertStringToArrayList_메서드로_string_ArrayList_변환() {
        String input = "123";
        assertThat(convertStringToArrayList(input)).containsExactly('1','2','3');
    }

    @DisplayName("get ball count")
    @ParameterizedTest(name = "{index}. {displayName} user={0} computer={1} ball={2}")
    @CsvSource({"'123','456',0", "'123','312',3", "'136','378',1", "'327','752',2"})
    void getBallCount_ball_몇인지_확인(String input1, String input2, int result) {
        assertThat(getBallCount(input1, input2)).isEqualTo(result);
    }

    @DisplayName("get strike count")
    @ParameterizedTest(name = "{index}. {displayName} user={0} computer={1} strike={2}")
    @CsvSource({"'123','456',0", "'123','132',1", "'123','153',2", "'123','123',3"})
    void getStrikeCount_strike_몇인지_확인(String input1, String input2, int result) {
        assertThat(getStrikeCount(input1, input2)).isEqualTo(result);
    }

    @DisplayName("get ball & strike count message")
    @ParameterizedTest(name = "{index}. {displayName} ball={0} strike={1} message={2}")
    @CsvSource({"0,0,'낫싱'","1,2,'1볼 2스트라이크'","0,3,'3스트라이크'","3,0,'3볼'"})
    void getBallStrikeCountMessage_strike_ball_count_message_얻기(int input1, int input2, String result) {
        assertThat(getBallStrikeCountMessage(input1, input2)).isEqualTo(result);
    }

    @DisplayName("check end game")
    @ParameterizedTest(name = "{index}. {displayName} message={0} result={1}")
    @CsvSource({"'낫싱',false", "'3스트라이크', true"})
    void checkEndGame_볼카운트_메세지에_따른_게임_끝내기_여부_확인(String input, boolean result) {
        assertThat(checkEndGame(input)).isEqualTo(result);
    }

    @DisplayName("재시작 여부 확인하기")
    @ParameterizedTest(name = "{index}. {displayName} input={0} result={1}")
    @CsvSource({"'1',true", "'2', false"})
    void checkRestartGame_입력받은_숫자에_따른_재시작_여부_판단(String input, boolean result) {
        assertThat(checkRestartGame(input)).isEqualTo(result);
    }

    @DisplayName("재시작 여부 확인하기 예외 처리")
    @Test
    void checkRestartGame_잘못된_숫자를_입력받은_경우_예외처리() {
        String input = "3";
        assertThatThrownBy(() -> checkRestartGame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 진행 여부에 대한 수를 잘못 입력하셨습니다!");
    }
}