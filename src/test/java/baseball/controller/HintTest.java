package baseball.controller;

import static org.junit.jupiter.api.Assertions.*;


import baseball.CONSOLE;
import baseball.view.InputView;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Hint 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class HintTest {

    private static void setConsole(String expect) {
        InputStream console = CONSOLE.setInputStream(expect);
        System.setIn(console);
    }


    @ParameterizedTest
    @CsvSource(value = {"123","457","369"})
    public void 힌트_생성(String readLine){
        //given
        setConsole(readLine);

        //when
        List<Integer> builder = new Hint().buildHint();
        int expect = 2;
        int actual = builder.size();

        //then
        assertEquals(expect,actual);

    }

}