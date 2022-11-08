package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    /*@Test
    void printResult_테스트() throws Exception{
        Application ce = new Application();
        List<Integer> ballAndStrike = new ArrayList<>();
        ballAndStrike.add(0,1);
        ballAndStrike.add(1,1);
        String str = "1볼 1스트라이크";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(str.getBytes());
        System.setIn(in);
        ce.printResult(ballAndStrike);
        assertThat("1볼 1스트라이크").isEqualTo(ce.toString());
    }
    */
    
    @Test
    void compareComputerAndUser_테스트(){
        Application ce = new Application();
        List<Integer> computerNumberList = new ArrayList<>();
        List<Integer> userNumberList = new ArrayList<>();

        computerNumberList.add(0,1);
        computerNumberList.add(0,2);
        computerNumberList.add(0,3);
        userNumberList.add(0,1);
        userNumberList.add(1,2);
        userNumberList.add(2,3);

        List<Integer> ballAndStrike = new ArrayList<>();
        ballAndStrike.add(0,2);
        ballAndStrike.add(1,1);

        assertEquals(ballAndStrike.get(0),ce.compareComputerAndUser(computerNumberList,userNumberList).get(0));
        assertEquals(ballAndStrike.get(1),ce.compareComputerAndUser(computerNumberList,userNumberList).get(1));

    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
