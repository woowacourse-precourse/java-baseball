package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    //각 클래스별로 테스트를 나누기 위해서 공백으로 구분
    @Test
    void 컴퓨터_숫자_크기_테스트(){
        Assertions.assertThat(Application.reComputerNumber().size()).isEqualTo(3);
    }
    @Test
    void 컴퓨터_숫자_다른숫자_테스트(){
        assertFalse(Application.reComputerNumber().get(0).equals(Application.reComputerNumber().get(1)));
        assertFalse(Application.reComputerNumber().get(0).equals(Application.reComputerNumber().get(2)));
    }
    @Test
    void 숫자_동일여부_테스트(){
        assertTrue(Application.checkTwoNumbersAreSame(1,1));
        assertFalse(Application.checkTwoNumbersAreSame(1,3));
    }
    @Test
    void 유저_입력_숫자_예외_테스트(){
        List<String> testStringList = Arrays.asList("044","abc","1234");
        for(int i=0;i<testStringList.size();i++){
            int finalI = i;
            assertSimpleTest(()->
                    assertThatThrownBy(()-> Application.checkUserInput(testStringList.get(finalI)))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void String_to_IntegerList_테스트(){
        List<Integer> integerList = Arrays.asList(1,2,3);
        Assertions.assertThat(Application.StringToIntegerList("123")).isEqualTo(integerList);
    }

    @Test
    void String_to_IntegerList_예외처리포함_테스트(){
        List<Integer> integerList = Arrays.asList(1,2,3);
        Assertions.assertThat(Application.getUserIntegerList("123")).isEqualTo(integerList);

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
