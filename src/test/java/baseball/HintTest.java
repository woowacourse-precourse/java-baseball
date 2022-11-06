package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HintTest {

    private static Hint hint;

    @BeforeAll
    static void initAll(){
        hint = new Hint();
    }

    @DisplayName("볼,스트라이크 테스트")
    @Test()
    void 볼_스트라이크_테스트(){
        List<String> comList = List.of("3","1","5");
        List<String> userList = List.of("3","2","1");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        hint.hintCalculator(comList,userList);

        assertThat("1볼 1스트라이크\n").isEqualTo(out.toString());
    }

}
