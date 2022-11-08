package baseball;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }


    @DisplayName("기능 요구사항 1")
    @Test
    void getAnswerNum_메서드_정답길이_3(){
        List<Integer> answer = getAnswerNum();
        assertThat(answer.size()).isEqualTo(3);
    }

    @DisplayName("기능 요구사항 1")
    @Test
    void getAnswerNum_메서드_정답_중복없음(){
        List<Integer> answer = Application.getAnswerNum();
        assertThat(answer.size()).isEqualTo(answer.stream().distinct().count());
    }

    @DisplayName("기능 요구사항 2")
    @Test
    void inputGuess_메서드_입력값_받기(){
    }

    @DisplayName("기능 요구사항 3")
    @Test
    void checkGuess_메서드_입력값_스트라이크_반환() throws IOException {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(1, 2, 3);

        String result = Application.checkGuess(answer, guess);
        assertThat(result.equals("3스트라이크"));
    }

    @DisplayName("기능 요구사항 3")
    @Test
    void checkGuess_메서드_입력값_볼_반환() throws IOException {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(2, 1, 5);

        String result = Application.checkGuess(answer, guess);
        assertThat(result.equals("2볼"));
    }

    @DisplayName("기능 요구사항 3")
    @Test
    void checkGuess_메서드_입력값_낫싱_반환() throws IOException {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(4, 5, 6);

        String result = Application.checkGuess(answer, guess);
        assertThat(result.equals("낫싱"));
    }

    @DisplayName("기능 요구사항 4")
    @Test
    void cntBallStrike_메서드_볼스트라이크_개수세기(){
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(2, 4, 3);
        int[] cnt = Application.cntBallStrike(answer, guess);

        //cnt[0] ball, cnt[1] strike
        assertThat(cnt[0]).isEqualTo(1);
        assertThat(cnt[1]).isEqualTo(1);
    }

    @DisplayName("기능 요구사항 5")
    @Test
    void endGame_메서드_게임종료() {
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
