package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.ConsoleInput;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ValidityCheckerTest {

    private ConsoleInput input;
    private ValidityChecker checker;

    @BeforeEach
    void setUp() {
        checker = new ValidityChecker();
    }
//    String 상태로 내가 넣어준 테스트용 input을 바이트 코드로 바꾸어 준다.
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Order(1)
    @DisplayName("유효성 검사 테스트")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"123", "321", "789"})
    void    inputnumberValidate(String inputString) {
        checker.validateNumberInput(inputString, 3);
    }

    @Order(2)
    @DisplayName("유효성 검사 1. 유효한 길이")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"123", "321", "789"})
    void    isInputNumberIsValidLength(String inputString) {
        InputStream in = generateUserInput(inputString);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> checker.validLength(scanner.toString(), 3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input의 길이가 유효하지 않습니다");
    }

    @Order(3)
    @DisplayName("유효성 검사 2. 유효하지 않은 길이")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"1234", "32", "789123"})
    void    isInputNumberIsUnvalidLength(String inputString) {
        InputStream in = generateUserInput(inputString);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> checker.validLength(scanner.toString(), 3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input의 길이가 유효하지 않습니다");
    }

    @Order(4)
    @DisplayName("유효성 검사 3. 유효한 구성요소")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"123", "321", "789"})
    void    isInputNumberIsValidElement(String inputString) {
        InputStream in = generateUserInput(inputString);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> checker.validElement(scanner.toString()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input의 구성요소가 0을 제외한 숫자로만 이루어지지 않습니다");
    }

    @Order(5)
    @DisplayName("유효성 검사 4. 유효하지 않은 구성요소")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"ㅁ23", "a21", "023"})
    void    isInputNumberIsUnValidElement(String inputString) {
        InputStream in = generateUserInput(inputString);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> checker.validElement(scanner.toString()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input의 구성요소가 0을 제외한 숫자로만 이루어지지 않습니다");
    }

    @Order(6)
    @DisplayName("유효성 검사 5. 중복성 확인 유효한 경우")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"954", "321", "123"})
    void    isInputNumberIsNotOverlap(String inputString) {
        InputStream in = generateUserInput(inputString);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> checker.validContinuity(scanner.toString(), 3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input의 구성요소가 중복됩니다");
    }

    @Order(7)
    @DisplayName("유효성 검사 5. 중복성 확인 유효하지 않은 경우")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"954", "321", "123"})
    void    isInputNumberIsOverlap(String inputString) {
        InputStream in = generateUserInput(inputString);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> checker.validContinuity(scanner.toString(), 3))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input의 구성요소가 중복됩니다");
    }
}