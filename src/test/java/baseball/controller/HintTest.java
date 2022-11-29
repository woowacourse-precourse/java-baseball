package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;

import baseball.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Hint 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class HintTest {

    private InputView inputView;
    private Hint hint;

    public static InputStream setReadLine(String readLine) {

        return new ByteArrayInputStream(readLine.getBytes());
    }

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        hint = new Hint();
    }


    @ParameterizedTest
    @CsvSource(value = {"123", "246", "926"})
    public void 힌트_생성(String readLine){
        //given
        InputStream console = setReadLine(readLine);
        System.setIn(console);

        hint.buildHint();
        int actualBall = hint.getBall();
        int actualStrike = hint.getStrike();

        //when
        boolean expectBall =  actualBall > 0;
        boolean expectStrike =  actualStrike > 0;

        //then
        assertEquals(expectBall, true);
        assertEquals(expectStrike, true);
    }
}