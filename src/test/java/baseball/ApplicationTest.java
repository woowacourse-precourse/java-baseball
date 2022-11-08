package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
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
    void checkUserNumberLengthTest() {
        String input = "123";

        assertThat(true).isEqualTo(Application.checkUserNumberLength(input));
    }

    @Test
    void  checkUserNumberIsIntegerTest() {
        String input = "32A";

        assertThat(false).isEqualTo(Application.checkUserNumberIsInteger(input));
    }

    @Test
    void checkUserNumberIsDuplicateTest() {
        String input = "323";

        assertThat(false).isEqualTo(Application.checkUserNumberIsDuplicate(input));
    }

    @Test
    void checkingUserNumberIsCorrectTest() {
        String input = "123";

        assertThat(true).isEqualTo(Application.checkUserNumberIsDuplicate(input));
    }

    @Test
    void checkUserNumberTest() {

        assertThatThrownBy(() -> Application.checkUserNumber("A123")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkReplayNumberLengthTest() {

        assertThat(true).isEqualTo(Application.checkUserNumberLength("1"));
    }

    @Test
    void checkReplayNumberCountTest() {

        assertThat(true).isEqualTo(Application.checkReplayNumberCount("1"));
        assertThat(true).isEqualTo(Application.checkReplayNumberCount("2"));
    }

    @Test
    void checkReplayNumberTest() {

        assertThatThrownBy(() -> Application.checkReplayNumber("3")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkAndCountBallTest() {

        assertThat(Application.checkAndCountBall(0, 1, 1, 1, 2)).isEqualTo(1);
    }

    @Test
    void countingBallTest() {

        // given
        List<Integer> random_input = new ArrayList<>();
        random_input.add(1);
        random_input.add(2);
        random_input.add(3);

        // when
        int[] user_input = {2, 3, 1};

        // then
        assertThat(Application.countingBall(0, user_input, random_input)).isEqualTo(3);
    }

    @Test
    void countingStrikeTest() {

        // given
        List<Integer> random_input = new ArrayList<>();
        random_input.add(1);
        random_input.add(2);
        random_input.add(3);

        // when
        int[] user_input = {1, 2, 3};

        // then
        assertThat(Application.countingStrike(0, user_input, random_input)).isEqualTo(3);
    }

    @Test
    void checkThreeStrikeTest() {

        // given
        List<Integer> random_input = new ArrayList<>();
        random_input.add(1);
        random_input.add(2);
        random_input.add(3);

        // when
        int[] user_input = {1, 2, 3};

        // then
        assertThat(Application.checkThreeStrike(Application.countingStrike(0, user_input, random_input))).isEqualTo(true);
    }

    @Test
    void printCountTest() {

        ByteArrayOutputStream message = new ByteArrayOutputStream();
        System.setOut(new PrintStream(message));

        Application.printCount(0, 2);
        Application.printCount(2, 0);
        Application.printCount(1, 2);
        Application.printCount(0, 0);
        Assertions.assertEquals("2스트라이크\n2볼\n1볼 2스트라이크\n낫싱\n", message.toString());

        System.setOut(System.out);
    }

    @Test
    void showGameStartTest() {

        ByteArrayOutputStream message = new ByteArrayOutputStream();
        System.setOut(new PrintStream(message));

        Application.showGameStart();
        Assertions.assertEquals("숫자 야구 게임을 시작합니다.\n", message.toString());

        System.setOut(System.out);
    }

    @Test
    void endGameTest() {

        ByteArrayOutputStream message = new ByteArrayOutputStream();
        System.setOut(new PrintStream(message));

        Application.endGame();
        Assertions.assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", message.toString());

        System.setOut(System.out);
    }

    @Test
    void replayGameTest() {

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(true).isEqualTo(Application.replayGame());
    }

    @Test
    void putInNumberTest() {

        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat("123").isEqualTo(Application.putInNumber());

        System.setOut(System.out);
    }

    @Test
    void addUserNumberInUserArrayTest() {

        String input = "123";
        int[] array = {0, 0, 0};

        Application.addUserNumberInUserArray(array, input);

        int[] result = {1, 2, 3};

        assertThat(result).isEqualTo(array);

    }

    @Test
    void playGameTest() {

        List<Integer> random_input = new ArrayList<>();
        random_input.add(1);
        random_input.add(2);
        random_input.add(3);

        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Application.playGame(random_input);
    }

    @Test
    void putInRandomNumberTest() {

        List<Integer> random_input = new ArrayList<>();
        Application.putInRandomNumber(random_input);

        assertThat(true).isEqualTo(random_input.get(0) != random_input.get(1) && random_input.get(1) != random_input.get(2)
                && random_input.get(2) != random_input.get(0));
    }

    @Test
    void startGameTest() {

        showGameStartTest();
        playGameTest();
        replayGameTest();

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
