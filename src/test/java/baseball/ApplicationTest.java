package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;

import static baseball.Application.generateComputerNumber;
import static baseball.Application.welcomeMessage;
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
    void 안내메시지_테스트(){
        String msg = "숫자 야구 게임을 시작합니다.";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        welcomeMessage();
        assertThat(msg).isEqualTo(out.toString().trim());
    }

   @Test
   void 랜덤숫자생성_테스트(){
       List<Integer> randomNumbers = generateComputerNumber();
       assertThat(new HashSet<>(randomNumbers).size()).isEqualTo(randomNumbers.size());
       for (Integer i:randomNumbers) {
           int digit = i.intValue();
           assertThat(digit).isBetween(1,9);
       }
   }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
