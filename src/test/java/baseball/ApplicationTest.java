package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        for(int i=0;i<3;i++){
            System.out.print(computer.get(i));
        }
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
        List<Integer> computer=getNumberBaseball();
        String trynumber= "468";
        List<Integer> user=transformInteger(trynumber);
        System.out.print(strikeCount(user,computer)+" "+computer.toString());
    }
    @Test
    void 볼카운트_테스트(){

        List<Integer> computer=getNumberBaseball();
        String trynumber= "468";
        List<Integer> user=transformInteger(trynumber);
        System.out.print(ballCount(user,computer)+" "+computer.toString());

    }
    @Test
    void 스트라이크카운트_볼카운트_출력테스트(){
        resultAnswer(0,0);
    }
    @Test
    void 게임종료스위치_테스트(){
        List<Integer> computer=new ArrayList<>();
        computer.add(1);
        computer.add(2);
        computer.add(3);
        List<Integer> user=new ArrayList<>();
        user.add(1);
        user.add(2);
        user.add(3);
        checkNumber(user,computer);
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
}
