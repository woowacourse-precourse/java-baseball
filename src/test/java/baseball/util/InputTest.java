package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    private Input aInput;
    private InputStream inputStream;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        aInput = new Input();
        scanner = new Scanner(System.in);
    }

    private static InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("사용자가 입력한 값을 받는 기능에 사용되는 메서드를 테스트")
    @Test
    void readUserInput() {
        String theInput = "234";
        inputStream = generateInput(theInput);
        System.setIn(inputStream);

        String inputByRead = aInput.readUserInput();
        assertThat(theInput).isEqualTo(inputByRead);
    }

    @DisplayName("사용자가 입력한 값을 받는 기능")
    @Test
    void setUserInput() {
        String theInput = "123";
        inputStream = generateInput(theInput);
        System.setIn(inputStream);

        aInput.setUserInputByRead();

        assertThat(theInput).isEqualTo(aInput.getUserInput());
    }
}