package baseball;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void setUserInput_WhenRun_PrintStartStatement() {
        String userInput = "111";
        Consumer<String> c =  input -> System.out.println("숫자를 입력해주세요 : " + input);
        c.accept(userInput);
        assertEquals("숫자를 입력해주세요 : 111", outputStreamCaptor.toString().trim());
    }
}