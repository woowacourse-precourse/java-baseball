package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.io.*;
import java.util.List;

import static baseball.Application.*;
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
    void 숫자생성_테스트(){
        List<Integer> computer=getNumberBaseball();
        System.out.print(computer);
    }
    @Test
    void 중복체크_테스트(){
        List<Integer> computer=List.of(1,2);
        checkDuplicate(2,computer);
        assertThat(computer.size()==2);

    }
    @Test
    void 입력_테스트() {

        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<Integer> user=getInput();
        assertThat(user).containsExactly(1,2,3);

    }
    

    @Test
    void 입력받은숫자_리스트변환테스트(){
        String trynumber= "468";
        List<Integer> user=transformInteger(trynumber);
        for(int i=0;i<3;i++){
            System.out.print(user.get(i));
        }
    }
    @Test
    void 스트라이크카운트_테스트(){
        strikeAnswer(3);
    }
    @Test
    void 볼카운트_테스트(){

        List<Integer> computer=getNumberBaseball();
        String trynumber= "468";
        List<Integer> user=transformInteger(trynumber);
        assertThat(user).contains(4).contains(6).contains(8);

    }
    @Test
    void 스트라이크카운트_볼카운트_출력테스트(){
        resultAnswer(3,0);
    }
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sss"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sssg"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
