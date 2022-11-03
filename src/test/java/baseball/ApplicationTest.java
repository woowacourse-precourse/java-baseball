package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ApplicationTest extends NsTest {

    @Test
    void when에_전달한_메소드를_호출하면_false를리턴()
    {
        List<String> listMock = Mockito.mock(List.class);
        when(listMock.add(anyString())).thenReturn(false);

        boolean added = listMock.add("1234");
        assertThat(added).isFalse();
    }
    @Test
    void 연속적으로_스터빙도_가능하다()
    {
        List<String> mockedList2 = Mockito.mock(List.class);
        when(mockedList2.get(0)).thenReturn("Hello", "Dexter");

        assertThat(mockedList2.get(0)).isEqualTo("Hello");
        assertThat(mockedList2.get(0)).isEqualTo("Dexter");
        assertThat(mockedList2.get(0)).isEqualTo("Dexter");
    }

    void runMain을통한_입출력을_이용하여_채점을하는_시스템(){
//        System.out.println("낫싱");
//        System.out.println("3스트라이크");
//        System.out.println("1볼 1스트라이크");
//        System.out.println("3스트라이크");
//        System.out.println("게임 종료");

        throw new IllegalArgumentException();
    }

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

//    @Override
//    public void runMain() {
//        runMain을통한_입출력을_이용하여_채점을하는_시스템();
//    }
}
