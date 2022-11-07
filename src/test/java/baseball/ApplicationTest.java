package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    // - 게임 실행 테스트 - //
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

    // - 예외 테스트 - //
    @Test
    void 게임종료_후_에러_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> assertRandomNumberInRangeTest(
                        () -> {
                            run("135", "3");
                            assertThat(output()).contains("3스트라이크", "게임 종료");
                        },
                        1, 3, 5
                )).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자가_아닌_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_너무_긴_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_너무_짧은_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // - 함수별 기능 테스트 - //
    @Test
    void 정답수의_중복성_검증() {
        Computer com = new Computer();
        com.makeAnswerNum();
        List<Integer> ans = com.getAnswer();

        for (Integer i : ans) {
            // 배열 요소가 중복없이 하나씩만 들어있는지 검증
            assertThat(Collections.frequency(ans, i)).isEqualTo(1);
        }
    }

    @Test
    void 유저_입력_문자열을_Integer_List로_전환_기능_검증() {
        User user = new User();
        user.convertInput("123");
        assertThat(user.getUserNumbers()).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 볼_스트라이크_카운트_함수_기능_검증() {
        AnswerChecker ans;

        //case 1
        ans = new AnswerChecker(Arrays.asList(1, 2, 3));
        ans.checkStrikeOrBall(Arrays.asList(1, 2, 4));

        assertThat(ans.getStrikeCnt()).isEqualTo(2);
        assertThat(ans.getBallCnt()).isEqualTo(0);

        //case 2
        ans = new AnswerChecker(Arrays.asList(1, 2, 3));
        ans.checkStrikeOrBall(Arrays.asList(2, 3, 1));

        assertThat(ans.getBallCnt()).isEqualTo(3);
        assertThat(ans.getStrikeCnt()).isEqualTo(0);

        //case 3
        ans = new AnswerChecker(Arrays.asList(1, 2, 3));
        ans.checkStrikeOrBall(Arrays.asList(4, 5, 6));

        assertThat(ans.getBallCnt()).isEqualTo(0);
        assertThat(ans.getStrikeCnt()).isEqualTo(0);
    }

    @Test
    void 메시지_작성_기능_검증() {
        AnswerChecker answerChecker;
        Messenger messenger;

        //case 1
        answerChecker = new AnswerChecker(Arrays.asList(1,2,3));
        answerChecker.checkStrikeOrBall(Arrays.asList(1,3,5));

        messenger = new Messenger(answerChecker);
        messenger.printResultMessage();
        assertThat(output().contains("1볼 1스트라이크")).isTrue();

        //case 2
        answerChecker = new AnswerChecker(Arrays.asList(1,2,3));
        answerChecker.checkStrikeOrBall(Arrays.asList(5,3,1));

        messenger = new Messenger(answerChecker);
        messenger.printResultMessage();
        assertThat(output().contains("2볼")).isTrue();

        //case 3
        answerChecker = new AnswerChecker(Arrays.asList(1,2,3));
        answerChecker.checkStrikeOrBall(Arrays.asList(1,2,3));

        messenger = new Messenger(answerChecker);
        messenger.printResultMessage();
        assertThat(output().contains("3스트라이크")).isTrue();

        //case 4
        answerChecker = new AnswerChecker(Arrays.asList(1,2,3));
        answerChecker.checkStrikeOrBall(Arrays.asList(4,5,6));

        messenger = new Messenger(answerChecker);
        messenger.printResultMessage();
        assertThat(output().contains("낫싱")).isTrue();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
