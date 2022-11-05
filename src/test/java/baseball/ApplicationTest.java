package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import java.awt.desktop.AppForegroundListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

class ApplicationTest extends NsTest {

    @Test
    void 게임_입력_값_유효성_테스트() {
        assertSimpleTest(() ->
                //runException(args) args는 Application.Main()을 실행할때 들어가는 inputStream
                assertThatThrownBy(() -> runException("456", "123", "ㄱㄴㄷ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 통합_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    //run() 의 매개변수 : 게임 시작시 사용자가 입력하는 inputStream
                    run("123", "456", "345", "1", "456", "123", "2");
                    //프로그램이 종료될때까지의 outputStream = output(), 출력된 문자열중 contains() 안의 문자열이 존재하는지 테스트
                    assertThat(output()).contains("낫싱", "2볼", "3스트라이크","낫싱", "3스트라이크", "게임 종료");
                },
                //랜덤으로 만들어지는 값을 임의가 아닌 직접 넣어준다 밑의 경우 첫번째로 3,4,5, 두번째로 1,2,3 이 만들어짐
                // assertRandomNumberInRangeTest -> assertRandomTest ->
                3, 4, 5, 1, 2, 3
        );
    }

    @ParameterizedTest
    @DisplayName("입력된 값이 1이면 true, 2면 false 리턴하는 기능 테스트")
    @CsvSource(value = {"1, true", "2, false"})
    void checkOrderNumberValue(String inputOrderNumber, boolean expected) {

        boolean result = Application.checkOrderNumberValue(inputOrderNumber);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("입력된 게임을 계속할지 확인하는 명령어에 대한 유효성 검사 기능 테스트")
    @ValueSource(strings = {"3", "   ", "rkadsf", "가나다라마사앚차카탚하"})
    void checkOrderNumberValidationTest(String inputNumber) {

        assertThatThrownBy(() -> Application.checkOrderNumberValidation(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("플레이어로 부터 게임을 계속할지에 대한 입력값을 받아오는 기능 테스트")
    @ValueSource(strings = {"2", "1", "3"})
    void inputOrderNumberTest(String inputOrderNumber) {

        InputStream inputStream = new ByteArrayInputStream(inputOrderNumber.getBytes());
        System.setIn(inputStream);

        String orderNumber = Application.inputOrderNumber();

        assertThat(orderNumber).isEqualTo(inputOrderNumber);
    }

    @ParameterizedTest
    @DisplayName("분석한 결과가 3스트라이크 일 경우 true, 아닐 경우 false가 리턴되는지 확인 테스트")
    @CsvSource(value = {"1, 2, true", "0, 3, true", "0, 0, true", "2, 0, true", "3, 0, false"})
    void resultMessagePrintRetrunTest(int strikeNumber, int ballNumber, boolean expectedResult) {

        Map<String, Integer> resultMap = Map.of(
                "strike", strikeNumber,
                "ball", ballNumber
        );

        boolean result = Application.resultMessagePrint(resultMap);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("분석한 결과에 따라 알맞은 내용이 출력되는지 확인 테스트")
    @CsvSource(value = {"1, 2, 2볼 1스트라이크", "0, 3, 3볼", "0, 0, 낫싱", "2, 0, 2스트라이크", "3, 0, 3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"})
    void resultMessagePrintTest(int strikeNumber, int ballNumber, String expectedResultMessage) {

        Map<String, Integer> resultMap = Map.of(
                "strike", strikeNumber,
                "ball", ballNumber
        );
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        if (strikeNumber == 3) {
            expectedResultMessage = "3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        Application.resultMessagePrint(resultMap);


        assertThat(outputStream.toString().trim()).isEqualTo(expectedResultMessage);
    }

    @ParameterizedTest
    @DisplayName("입력받은 값을 분석하여 Strike, ball 개수 집계 기능 테스트")
    @CsvSource(value = {"123, 456, 0, 0", "123, 123, 3, 0", "145, 415, 1, 2", "567, 756, 0, 3"})
    void analyzeInputNumberTest(String inputNumber, String setNumber, int strike, int ball) {

        Map<String, Integer> resultMap = Application.analyzeInputNumber(inputNumber, setNumber);

        assertThat(resultMap.get("strike")).isEqualTo(strike);
        assertThat(resultMap.get("ball")).isEqualTo(ball);
    }

    @ParameterizedTest
    @DisplayName("입력한 수가 유효하지 않을때 Exception이 발생하는지 통합 테스트")
    @ValueSource(strings = {"가나다", "122", "가가나나다다라마마바123124", "", "  "})
    void checkInputNumberValidationTest(String inputNumber) {

        boolean isTestSuccess = false;

        try {
            Application.checkInputNumberValidation(inputNumber);
        } catch (IllegalArgumentException e) {
            isTestSuccess = true;
        }

        assertThat(isTestSuccess).isTrue();
    }

    @DisplayName("입력된 수가 1 ~ 9 사이의 값이 아닐 경우 Exception 발생하는지 테스트")
    @Test
    void isNumberTest() {

        String inputNumber = "만23";
        boolean isTestSuccess = false;

        try {
            Application.isNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            isTestSuccess = true;
        }

        assertThat(isTestSuccess).isTrue();
    }

    @DisplayName("입력된 수가 중복되어 있는 경우 Exception 발생하는지 테스트")
    @Test
    void checkDuplicationTest() {

        String inputNumber = "112";
        boolean isTestSuccess = false;

        try {
            Application.checkDuplication(inputNumber);
        } catch (IllegalArgumentException e) {
            isTestSuccess = true;
        }

        assertThat(isTestSuccess).isTrue();
    }

    @DisplayName("입력된 수가 3이 아닐경우 Exception 발생하는지 테스트")
    @Test
    void checkLengthTest() {

        String inputNumber = "1234";
        boolean isTestSuccess = false;

        try {
            Application.checkLength(inputNumber);
        } catch (IllegalArgumentException e) {
            //pass
            isTestSuccess = true;
        }

        assertThat(isTestSuccess).isTrue();
    }

    @DisplayName("숫자 입력 기능 테스트")
    @Test
    void inputNumberFromPlayerTest() {

        String inputString = "456";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        String inputNumber = Application.inputNumberFromPlayer();

        assertThat(inputNumber).isEqualTo(inputString);

    }

    @DisplayName("1 ~ 9 사이의 값으로 중복 없이 설정되는지 테스트")
    @Test
    void setNumberTest() {

        int testNumber = 1000;
        boolean result = false;
        String number;

        for (int tryNumber = 0; tryNumber < testNumber; tryNumber++) {
            number = Application.setNumber();
            result = checkSetNumber(number);
            if (result == false) {
                break;
            }
        }

        assertThat(result).isTrue();
    }

    private boolean checkSetNumber(String number) {

        if (number.length() != 3) {
            return false;
        }

        char first = number.charAt(0);
        char second = number.charAt(1);
        char third = number.charAt(2);

        if (first == second || first == third || second == third) {
            return false;
        }

        boolean digitCheckResult = true;
        digitCheckResult = isDigitExceptZero(first);
        digitCheckResult = isDigitExceptZero(second);
        digitCheckResult = isDigitExceptZero(third);

        if (digitCheckResult == false) {
            return false;
        }

        return true;
    }

    private boolean isDigitExceptZero(char digit) {

        if (digit > '0' && digit <= '9') {
            return true;
        } else {
            return false;
        }
    }

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
}
