package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("InputView Class")
@DisplayNameGeneration(ReplaceUnderscores.class)
class InputViewTest {

    private InputView inputView;

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    public void 숫자_입력_받기(){

        InputStream readLine = setReadLine("926");
        System.setIn(readLine);

        String expect = "926";
        String actual = inputView.putReadLine();

        assertEquals(expect, actual);
    }
}