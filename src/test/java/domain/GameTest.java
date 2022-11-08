package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameTest {

    private Game game;
    private Scanner scanner;

    private static ByteArrayOutputStream outContent;
    private static PrintStream originalOut;
    private ValidityChecker checker = new ValidityChecker();

    @BeforeEach
    void setUp() {
        game = new Game(3);
    }

    //  String 상태로 내가 넣어준 테스트용 input을 바이트 코드로 바꾸어 준다.
    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    //  input값을 String으로 대체하여 Test를 실행하기 위한 Test용 코드
    private void generateNumberForTest(String input) {
        checker.validateRepalyGameInput(input);
    }

    private Scanner generateScanner(String inputString) {
        InputStream in = generateUserInput(inputString);
        System.setIn(in);
        return new Scanner(System.in);
    }

    @Test
    @Order(1)
    @DisplayName("유효성 검사 1. Null 확인")
    public void generateNumberValidateIsStringNotNull() {
        Assertions.assertThatThrownBy(() -> {
            generateNumberForTest("");
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Order(2)
    @DisplayName("유효성 검사 2. 유효한 값 1 확인")
    @ParameterizedTest(name = "{displayName}) {index} = {0} ")
    @ValueSource(strings = {"1", "2"})
    public void generateNumberValidateIsStringOne(String inputString) {
        scanner = generateScanner(inputString);
        assertThatThrownBy(() -> generateNumberForTest(scanner.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1, 또는 2를 입력해야 합니다.");
    }

    @Order(3)
    @DisplayName("유효성 검사 3. 유효하지 않은 값 확인")
    @ParameterizedTest(name = "{displayName}) {index} = {0} ")
    @ValueSource(strings = {"3", "4", "0"})
    public void generateNumberValidateIsStringUnavailable(String inputString) {
        scanner = generateScanner(inputString);
        assertThatThrownBy(() -> generateNumberForTest(scanner.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1, 또는 2를 입력해야 합니다.");
    }

    @Order(4)
    @DisplayName("유효성 검사 4. 기타 값 확인")
    @ParameterizedTest(name = "{displayName}) {index} = {0} ")
    @ValueSource(strings = {"a", "ㄱ", "5", "6", "50", "hello"})
    public void generateNumberValidateRandomTest(String inputString) {
        scanner = generateScanner(inputString);
        assertThatThrownBy(() -> generateNumberForTest(scanner.toString()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1, 또는 2를 입력해야 합니다.");

    }
}