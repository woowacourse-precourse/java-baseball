package baseball;

import baseball.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class functionTest {
    User user = new User();
    Score score = new Score(List.of(2, 5, 8));

    @Test
    @DisplayName("유저의 숫자는 1~9사이여야 한다")
    void 유저의_숫자_RangeCheck() {
        assertThrows(IllegalArgumentException.class, () -> {
            user.checkingNums("023");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.checkingNums("S23");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.checkingNums("-23");
        });
    }

    @Test
    @DisplayName("유저의 숫자는 각각의 다른 숫자여야 한다.")
    void 유저의_숫자_DistinctCheck() {
        assertThrows(IllegalArgumentException.class, () -> {
            user.checkingNums("112");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.checkingNums("111");
        });

    }

    @Test
    @DisplayName("유저의 숫자는 3자리여야 한다.")
    void 유저의_숫자_LengthCheck() {
        assertThrows(IllegalArgumentException.class, () -> {
            user.checkingNums("");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.checkingNums("1");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            user.checkingNums("1234");
        });
    }

    @Test
    @DisplayName("유저의 인풋값이 정확하게 저장되는지 확인")
    void 유저의_숫자리스트_확인() {
        assertEquals(List.of(1, 2, 3), user.inputToList("123"));
        assertEquals(List.of(6, 3, 9), user.inputToList("639"));
    }

    @Test
    @DisplayName("유저와 컴퓨터의 점수를 계산한다")
    void 유저의_결과를_계산한다() {
        score.setUserNums(List.of(2, 5, 8));
        score.countResult();
        assertEquals(3, score.strikeCnt);
        assertEquals(0, score.ballCnt);


        score.setUserNums(List.of(5, 2, 3));
        score.countResult();
        assertEquals(0, score.strikeCnt);
        assertEquals(2, score.ballCnt);

        score.setUserNums(List.of(1, 3, 4));
        score.countResult();
        assertEquals(0, score.strikeCnt);
        assertEquals(0, score.ballCnt);

    }


    @Test
    @DisplayName("유저와 결과를 출력한다.1")
    void 유저의_결과를_출력한다1() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        score.setUserNums(List.of(2, 5, 8));
        score.countResult();
        score.showResult();
        assertEquals("3스트라이크\n", out.toString());
    }

    @DisplayName("유저와 결과를 출력한다.2")
    void 유저의_결과를_출력한다2() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        score.setUserNums(List.of(3, 6, 7));
        score.countResult();
        score.showResult();
        assertEquals("낫싱\n", out.toString());


    }

    @DisplayName("유저와 결과를 출력한다.3")
    void 유저의_결과를_출력한다3() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        score.setUserNums(List.of(2, 7, 3));
        score.countResult();
        score.showResult();
        assertEquals("2볼 1스트라이크\n", out.toString());

    }

}
