package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserBallsInputTest {

    private UserBallsInput input;

    @BeforeEach
    void setUp() {
        input = new UserBallsInput(3);
    }

//    String 상태로 내가 넣어준 테스트용 input을 바이트 코드로 바꾸어 준다.
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Order(1)
    @DisplayName("Input 생성 테스트")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"123", "456", "987"})
        void inputSuccess(String inputString) {
            assertEquals(inputString, input.inputNumberTest(inputString));
        }

    @Order(2)
    @DisplayName("유효성 검사 테스트")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"123", "321"})
    void    inputnumberValidate(String inputString) {
        input.validityChecker(inputString);
    }

    @Order(3)
    @DisplayName("유효성 검사 1. 유효한 길이 확인")
    @ParameterizedTest(name ="{displayName}) {index} = {0} ")
    @ValueSource(strings = {"123", "321", "789"})
    void    isInputNumberIsValidLength(String inputString) {
        InputStream in = generateUserInput(inputString);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> input.validLength(scanner.toString()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("input의 길이가 유효하지 않습니다");
    }
//    @Test
//    @Order(4)
//    @DisplayName("유효성 검사 2. 유효하지 않은 길이 확인")
//    void    isInputNumberIsUnvalidLength() {
//        Assertions.assertThatThrownBy(() -> {
//            input.inputNumberTest("1234");
//        }).isInstanceOf(IllegalArgumentException.class);
//    }
}