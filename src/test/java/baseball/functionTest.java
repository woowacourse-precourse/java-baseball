package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class functionTest {

    User user = new User();
    Score score = new Score();
    Computer computer = new Computer();


    //기능목록2
    @Test
    @DisplayName("1.컴퓨터 숫자는 세 자리 이다.")
    void 컴퓨터_숫자_LengthCheck() {
        computer.setRandNums();
        assertEquals(3, computer.getNums().size());
    }

    @Test
    @DisplayName("2.컴퓨터 숫자는 모두 다른 세 숫자 이다.")
    void 컴퓨터_숫자_DistinctCheck() {
        computer.setRandNums();
        assertArrayEquals(computer.getNums().toArray(), computer.getNums().stream().distinct().toArray());
    }

    @Test
    @DisplayName("3.컴퓨터 숫자는 0~9사이이다.")
    void 컴퓨터_숫자_RangeCheck() {
        computer.setRandNums();
        boolean hasRangeError = false;
        for (int num : computer.getNums()) {
            if (num <= 0 || 9 < num) {
                hasRangeError = true;
                break;
            }
        }
        assertFalse(hasRangeError);
    }

    //기능목록3
    @Test
    @DisplayName("1.유저의 숫자는 1~9사이여야 한다")
    void 유저의_숫자_RangeCheck() {
        assertThrows(IllegalArgumentException.class, () -> user.checkingNums("023"));
        assertThrows(IllegalArgumentException.class, () -> user.checkingNums("S23"));
        assertThrows(IllegalArgumentException.class, () -> user.checkingNums("-23"));
    }

    @Test
    @DisplayName("2.유저의 숫자는 각각의 다른 숫자여야 한다.")
    void 유저의_숫자_DistinctCheck() {
        assertThrows(IllegalArgumentException.class, () -> user.checkingNums("112"));
        assertThrows(IllegalArgumentException.class, () -> user.checkingNums("111"));

    }

    @Test
    @DisplayName("3.유저의 숫자는 3자리여야 한다.")
    void 유저의_숫자_LengthCheck() {
        assertThrows(IllegalArgumentException.class, () -> user.checkingNums(""));
        assertThrows(IllegalArgumentException.class, () -> user.checkingNums("1"));
        assertThrows(IllegalArgumentException.class, () -> user.checkingNums("1234"));
    }

    //기능목록4
    @Test
    @DisplayName("1.유저의 결과 계산_Strike")
    void 유저_결과_계산_Strike() {
        calculateScore(List.of(2, 5, 8));
        assertEquals(3, score.getStrikeCnt());
        assertEquals(0, score.getBallCnt());
    }

    @Test
    @DisplayName("2.유저의 결과 계산_Ball")
    void 유저_결과_계산_Ball() {
        calculateScore(List.of(5, 2, 3));
        assertEquals(0, score.getStrikeCnt());
        assertEquals(2, score.getBallCnt());

    }

    @Test
    @DisplayName("3.유저의 결과 계산_Nothing")
    void 유저_결과_계산_Nothing() {
        calculateScore(List.of(1, 3, 4));
        assertEquals(0, score.getStrikeCnt());
        assertEquals(0, score.getBallCnt());
    }

    //기능목록5
    @Test
    @DisplayName("1.유저와 결과를 출력한다._스트라이크")
    void 유저_결과_출력_Strike() {
        OutputStream out = getOutputStream();
        calculateAndShowResult(List.of(2, 5, 8));
        assertEquals("3스트라이크", out.toString().trim());
    }

    @Test
    @DisplayName("2.유저와 결과를 출력한다._낫싱")
    void 유저_결과_출력_Nothing() {
        OutputStream out = getOutputStream();
        calculateAndShowResult(List.of(3, 6, 7));
        assertEquals("낫싱", out.toString().trim());
    }

    @Test
    @DisplayName("3.유저와 결과를 출력한다._볼과 스트라이크")
    void 유저_결과_출력_BallAndStrike() {
        OutputStream out = getOutputStream();
        calculateAndShowResult(List.of(2, 8, 3));
        assertEquals("1볼 1스트라이크", out.toString().trim());
    }

    @Test
    @DisplayName("4.유저와 결과를 출력한다._볼")
    void 유저_결과_출력_Ball() {
        OutputStream out = getOutputStream();
        calculateAndShowResult(List.of(8, 2, 5));
        assertEquals("3볼", out.toString().trim());
    }

    //기능목록 7
    @Test
    @DisplayName("게임 재실행 여부 확인중 유저 인풋값 에러")
    void 유저_재실행여부_인풋에러() {
        setInputStream("3");
        assertThrows(IllegalArgumentException.class,
                () -> user.scanWantReplayingGame()
        );
        setInputStream("S");
        assertThrows(IllegalArgumentException.class,
                () -> user.scanWantReplayingGame()
        );

        setInputStream("1");
        assertTrue(user.scanWantReplayingGame());

        setInputStream("2");
        assertFalse(user.scanWantReplayingGame());
    }


    private void calculateScore(List<Integer> input) {
        score.setAnswerNums(List.of(2, 5, 8));
        score.setUserNums(input);
        score.countResult();
    }

    private void calculateAndShowResult(List<Integer> input) {
        score.setAnswerNums(List.of(2, 5, 8));
        score.setUserNums(input);
        score.calculateAndShowHint();
    }

    private OutputStream getOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }

    private void setInputStream(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}
