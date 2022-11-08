package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void 유저_숫자_테스트() {
        //given
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        //when
        List<Integer> user = Application.createUserNumberList("123");

        //then
        assertThat(user).isEqualTo(test);
    }

    @Test
    void 숫자_비교_테스트() {
        //given
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        List<Integer> user = Application.createUserNumberList("732");


        //when
        int result = Application.compareNumberComputerWithUser(test, user);

        //given
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 스트라이크_개수_테스트() {
        //given
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        List<Integer> user = Application.createUserNumberList("763");


        //when
        int strikeCount = Application.strikeCount(test, user);

        //given
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 컴퓨터_랜덤숫자_개수_테스트() {
        //given
        List<Integer> computer = Application.computerNumberList();

        //then
        assertThat(computer.size()).isEqualTo(3);
    }

    @Test
    void 결과_판정_테스트() {
        //given
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        List<Integer> user = new ArrayList<>();
        user.add(8);
        user.add(2);
        user.add(1);

        //when
        String result = Application.resultJudgement(test, user);

        //given
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void userInput이_숫자가_아닐경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("가나다라"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void userInput이_중복일_경우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
