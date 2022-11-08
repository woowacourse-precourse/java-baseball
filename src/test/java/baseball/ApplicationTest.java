package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.exception.InputUserNumberException;
import baseball.service.BaseballGameService;
import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 숫자이외의_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_중복값_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("133"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_범위_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("130"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 컴퓨터_랜덤번호생성_테스트() {
        //given
        Computer computer = new Computer();
        List<Integer> list = List.of(1, 2, 3);
        //when
        computer.setRandomNumber(list);

        //then
        assertThat(computer.getRandomNumber().size()).isEqualTo(3);
    }

    @Test
    void 유저_입력값_생성_테스트() {
        //given
        User user = new User();
        List<Integer> list = List.of(1, 2, 3);

        //when
        user.setSelectNumber(list);

        //then
        assertThat(user.getSelectNumber().size()).isEqualTo(3);

    }

    @Test
    void 스트라이크_카운트_테스트() {
        //given
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber = List.of(1, 2, 3);
        BaseballGameService baseballGameService = new BaseballGameService();

        //when
        baseballGameService.updateStrikeCount(computerNumber, userNumber);

        //then
        assertThat(baseballGameService.getStrikeCount()).isEqualTo(3);
    }

    @Test
    void 볼_카운트_테스트() {
        //given
        List<Integer> computerNumber = List.of(3, 7, 8);
        List<Integer> userNumber = List.of(1, 2, 3);
        BaseballGameService baseballGameService = new BaseballGameService();

        //when
        baseballGameService.updateBallCount(computerNumber, userNumber);

        //then
        assertThat(baseballGameService.getBallCount()).isEqualTo(1);
    }


    @Test
    void 재시작여부_입력값_범위_오류() {
        //given
        String wrongNumber = "3";
        InputUserNumberException inputUserNumberException = new InputUserNumberException();

        //when,then
        assertThatThrownBy(() -> inputUserNumberException.checkInputRestartNumber(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작여부_입력값_길이_오류() {
        //given
        String wrongNumber = "32";
        InputUserNumberException inputUserNumberException = new InputUserNumberException();

        //when,then
        assertThatThrownBy(() -> inputUserNumberException.checkInputRestartNumber(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작여부_입력값_오류() {
        //given
        String wrongNumber = "a";
        InputUserNumberException inputUserNumberException = new InputUserNumberException();

        //when,then
        assertThatThrownBy(() -> inputUserNumberException.checkInputRestartNumber(wrongNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
