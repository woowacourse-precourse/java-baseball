package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.NumberAssert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // 갯수
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    /*@Test
    void 사용자_숫자_갯수_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 공백
    @Test
    void 사용자_숫자_공백_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1  "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_공백_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 2 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_숫자_공백_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 숫자 중복 테스트
    @Test
    void 사용자_숫자_중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 숫자 여부 테스트
    @Test
    void 사용자_숫자_여부_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("가나다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 0 여부 테스트
    @Test
    void 사용자_숫자_0_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }*/

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    /*// 컴퓨터 숫자 갯수 테스트
    @Test
    void 컴퓨터_숫자_갯수_테스트() {
        assertThat(Application.comNumber().size()==3);
    }

    // 컴퓨터 숫자 중복 테스트
    @Test
    void 컴퓨터_숫자_중복_테스트() {
        List comList = Application.comNumber();
        Set set = new HashSet<>();

        for(int i=0; i<comList.size(); i++) {
            set.add(comList.get(i));
        }

        assertThat(set.size()==3);
    }

    // 볼 테스트
    @Test
    void 볼_테스트() {
        List comList = new ArrayList<>();
        List userList = new ArrayList<>();

        comList.add(1);
        comList.add(2);
        comList.add(3);

        userList.add(3);
        userList.add(1);
        userList.add(2);

        Application.score(comList, userList);

        assertThat(output()).contains("3볼");
    }

    // 스트라이크 테스트
    @Test
    void 스트라이크_테스트() {
        List comList = new ArrayList<>();
        List userList = new ArrayList<>();

        comList.add(1);
        comList.add(2);
        comList.add(3);

        userList.add(1);
        userList.add(2);
        userList.add(4);

        Application.score(comList, userList);

        assertThat(output()).contains("2스트라이크");
    }

    // 낫싱 테스트
    @Test
    void 낫싱_테스트() {
        List comList = new ArrayList<>();
        List userList = new ArrayList<>();

        comList.add(1);
        comList.add(2);
        comList.add(3);

        userList.add(4);
        userList.add(5);
        userList.add(6);

        Application.score(comList, userList);

        assertThat(output()).contains("낫싱");
    }*/
}
