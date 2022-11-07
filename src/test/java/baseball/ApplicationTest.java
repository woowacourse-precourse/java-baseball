package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

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
    void 게임두번_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run( "135", "1", "589", "1", "123", "2");
                    assertThat(output()).contains("3스트라이크", "3스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 1, 2, 3
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
    void 사용자가_중복된_값_입력() throws Exception {

        //given
        String input = "222";
        UserInput userInput = new UserInput();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            // when
            userInput.getInput();
            fail();
        } catch (IllegalArgumentException e) {
            //then
            //pass
        }
    }

    @Test
    void 사용자가_세자리_아닌_입력() throws Exception {

        //given
        String input = "1234";
        UserInput userInput = new UserInput();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            // when
            userInput.getInput();
            fail();
        } catch (IllegalArgumentException e) {
            //then
            //pass
        }
    }

    @Test
    void 사용자가_문자_입력() throws Exception {

        //given
        String input = "abc";
        UserInput userInput = new UserInput();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            // when
            userInput.getInput();
            fail();
        } catch (IllegalArgumentException e) {
            //then
            //pass
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 랜덤숫자_체크() {

        //give
        final NumberGenerator numberGenerator = new NumberGenerator();

        //when
        final List<Integer> list = numberGenerator.generateNum();
        int[] computerNumbers = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            computerNumbers[i] = list.get(i).intValue();
        }

        //then
        assertThat(computerNumbers).doesNotHaveDuplicates();
    }

    @Test
    public void 스트라이크_볼_갯수_체크() {
        //given
        final BallCount ballCount = new BallCount();
        final List<Integer> computer = List.of(1, 2, 3);
        final List<Integer> user = List.of(3, 2, 1);
        final int[] result = {1, 2};

        //when
        for (int i = 0; i < 3; i++) {
            ballCount.checkStrikeOrBall(user, computer, i);
        }

        final int[] sb = {ballCount.getStrike(), ballCount.getBall()};

        //then
        assertThat(sb).isEqualTo(result);
    }
}
