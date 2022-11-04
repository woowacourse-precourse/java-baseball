package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

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
    void numberDuplicateCheckTest() {
        List<List<Integer>> checkList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            checkList.add(Start.startGame());
        }

        for (int j = 0; j < checkList.size(); j++) {
            Integer zeroIndex = checkList.get(j).get(0);
            assertThat(zeroIndex).isNotEqualTo(checkList.get(j).get(1));
            assertThat(zeroIndex).isNotEqualTo(checkList.get(j).get(2));
        }
    }

    @Test
    void sliceInputTest() {
        UserInput input = new UserInput();
        List<Integer> sliced = input.sliceInput("123");
        assertThat(sliced.get(0)).isEqualTo(1);
        assertThat(sliced.get(1)).isEqualTo(2);
        assertThat(sliced.get(2)).isEqualTo(3);
    }

    @Test
    void exceptionTest() {
        ExceptionCheck exceptionCheck = new ExceptionCheck();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationLength("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationLength(""))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationDuplicated("233"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationInputZero("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> exceptionCheck.verificationCharDetect("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void numberComparisonTest() {
        List<Integer> correctAnswer = List.of(1, 2, 3);
        List<Integer> slicedInput = List.of(3, 2, 1);

        NumberComparison comparison = new NumberComparison();
        int strikeCount = comparison.checkStrike(correctAnswer, slicedInput);
        int ballCount = comparison.checkBall(correctAnswer, slicedInput);

        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    void countPrintTestBallStrike() {
        int ballCount = 1;
        int strikeCount = 1;

        GameBranch gameBranch = new GameBranch();
        int result = gameBranch.status(ballCount, strikeCount);

        assertThat(result).isEqualTo(-1);
        assertThat(output()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void countPrintBall() {
        int ballCount = 2;
        int strikeCount = 0;

        GameBranch gameBranch = new GameBranch();
        int result = gameBranch.status(ballCount, strikeCount);

        assertThat(result).isEqualTo(-1);
        assertThat(output()).isEqualTo("2볼");
    }

    @Test
    void countPrintStrike() {
        int ballCount = 0;
        int strikeCount = 2;

        GameBranch gameBranch = new GameBranch();
        int result = gameBranch.status(ballCount, strikeCount);

        assertThat(result).isEqualTo(-1);
        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    void countPrintNothing() {
        int ballCount = 0;
        int strikeCount = 0;

        GameBranch gameBranch = new GameBranch();
        int result = gameBranch.status(ballCount, strikeCount);

        assertThat(result).isEqualTo(-1);
        assertThat(output()).isEqualTo("낫싱");
    }

    @Test
    void GameEnd() {
        GameBranch gameBranch = new GameBranch();
        int branchEnd = gameBranch.branch("2");
        assertThat(branchEnd).isEqualTo(-3);

        int branchReStart = gameBranch.branch("1");
        assertThat(branchReStart).isEqualTo(-2);
    }

    @Test
    void branchTest_END() {
        int GAME_END = -2;
        GameBranch gameBranch = new GameBranch();
        int branchStatus = gameBranch.branch("1");
        assertThat(GAME_END).isEqualTo(branchStatus);
    }

    @Test
    void branchTest_RESTART() {
        int GAME_END = -3;
        GameBranch gameBranch = new GameBranch();
        int branchStatus = gameBranch.branch("2");
        assertThat(GAME_END).isEqualTo(branchStatus);
    }

    @Test
    void branchTest_THROW_EXCEPTION() {
        GameBranch gameBranch = new GameBranch();
        assertSimpleTest(() ->
                assertThatThrownBy(() -> gameBranch.branch("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void reStartTest() {
        List<Integer> computer = Start.reStart();
        assertThat(computer.size()).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
