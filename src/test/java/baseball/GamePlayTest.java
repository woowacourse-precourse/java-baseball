package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GamePlayTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    void tearDown(){
        System.setOut(standardOut);
    }

    @Test
    void 결과_값이_스트라이크() {
        // given
        GamePlay gamePlay = new GamePlay();

        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1,7,4));
        List<Integer> uesrNumber = new ArrayList<>(Arrays.asList(1,7,8));

        //when
        gamePlay.getResult(uesrNumber,computerNumber);

        // then
        Assertions.assertEquals("2스트라이크",outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과_값이_볼(){

    }
    @Test
    void 결과_값이_볼과_스트라이크(){

    }
    @Test
    void 결과_값이_올_스트라이크(){

    }
    @Test
    void 결과_값이_낫싱(){

    }
    @Test
    void 컴퓨터의_숫자가_3자리(){

    }
    @Test
    void 컴퓨터의_숫자가_중복(){

    }
    @Test
    void 컴퓨터의_숫자가_숫자로만_구성(){

    }
    @Test
    void 사용자의_숫자가_3자리(){

    }
    @Test
    void 사용자의_숫자가_중복(){

    }
    @Test
    void 사용자의_숫자가_숫자로만_구성(){

    }

}
