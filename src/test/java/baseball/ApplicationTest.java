package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void validateThreeDifferentDigitsTest() {
        Application application = new Application();
        assertThatThrownBy(()-> application.validateThreeDifferentDigits("42")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> application.validateThreeDifferentDigits("2345")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> application.validateThreeDifferentDigits("434")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> application.validateThreeDifferentDigits("433")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> application.validateThreeDifferentDigits("223")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> application.validateThreeDifferentDigits("103")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateContinueEndTest(){
        Application application = new Application();
        assertThatThrownBy(()-> application.validateContinueEnd(3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printPointTest(){
        Application application = new Application();
        HashMap<String, Integer> ballStrikeNum = new HashMap<>();
        ballStrikeNum.put("ballNum", 1);
        ballStrikeNum.put("strikeNum", 1);
        application.printPoint(ballStrikeNum);
        ballStrikeNum.put("ballNum" , 0);
        ballStrikeNum.put("strikeNum", 0);
        application.printPoint(ballStrikeNum);
        ballStrikeNum.put("ballNum" , 0);
        ballStrikeNum.put("strikeNum", 3);
        application.printPoint(ballStrikeNum);
        assertThat(output()).contains("1볼 1스트라이크", "낫싱","3스트라이크");
    }

    @Test
    void findPointTest(){
        Application application = new Application();
        HashMap<String, Integer> ballStrikeNum = application.initializeBallStrikePoint();
        application.findPoint(List.of(1, 3, 5), "145",ballStrikeNum);
        assertThat(ballStrikeNum.get("strikeNum")).isEqualTo(2);
        assertThat(ballStrikeNum.get("ballNum")).isEqualTo(0);
    }

    @Test
    void continueOrEndTest(){
        Application application = new Application();
        command("2");
        assertThat(application.continueOrEnd()).isFalse();
        command("1");
        assertThat(application.continueOrEnd()).isTrue();
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    void playGameTest(){
        Application application = new Application();
        command("456", "123");
        application.playGame(List.of(1,2,3));
        assertThat(output()).contains("낫싱","3스트라이크");
    }

    @Test
    void gameStartTest(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("146", "597","238", "135", "2");
                    assertThat(output()).contains("1스트라이크", "1볼", "1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
