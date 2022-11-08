package baseball;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NumsInputFromUserTest {
    private NumsInputFromUser numsInputFromUser;
    private InputStream sysInBackup = System.in;


    @BeforeEach
    void setUp() {
        this.numsInputFromUser = new NumsInputFromUser();
    }


    @AfterEach
    void tearDown() {
        this.numsInputFromUser = null;
        System.setIn(sysInBackup);
    }

    @Test
    void exceptionTest1_세자리이상() {
        ByteArrayInputStream in = new ByteArrayInputStream("1000".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> numsInputFromUser.getInputNumForGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exceptionTest2_마이너스() {
        ByteArrayInputStream in = new ByteArrayInputStream("-123".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> numsInputFromUser.getInputNumForGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exceptionTest3_중복() {
        ByteArrayInputStream in = new ByteArrayInputStream("112".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> numsInputFromUser.getInputNumForGame())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_테스트() {
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        int[] inputNumForGame = numsInputFromUser.getInputNumForGame();

        assertThat(inputNumForGame).contains(1,2,3);
        assertThat(inputNumForGame.length).isEqualTo(3);
    }
}
