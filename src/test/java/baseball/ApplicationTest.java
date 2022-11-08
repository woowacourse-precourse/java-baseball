package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashSet;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

   @Test
   void 숫자입력_테스트_1(){
        String msg = "숫자를 입력해주세요 : ";
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(out));
        assertThat(getUserInputNumber()).isEqualTo(List.of(1,2,3));
        assertThat(out.toString().trim()).isEqualTo(msg.trim());
   }

    @Test
    void 숫자입력_테스트_2(){
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable thrown = catchThrowable(()->getUserInputNumber());
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자입력_테스트_3(){
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Throwable thrown = catchThrowable(()->getUserInputNumber());
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저와_컴퓨터_숫자_비교_테스트_1(){
        List<Integer> user = List.of(1,2,3);
        List<Integer> computer = List.of(1,2,3);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(compareUserNumberToComputers(user, computer)).isEqualTo(0);

        String msg = "3스트라이크";
        assertThat(msg.trim()).isEqualTo(out.toString().trim());

    }

    @Test
    void 유저와_컴퓨터_숫자_비교_테스트_2(){
        List<Integer> user = List.of(1,2,3);
        List<Integer> computer = List.of(3,2,4);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(compareUserNumberToComputers(user, computer)).isEqualTo(1);

        String msg = "1볼 1스트라이크";
        assertThat(msg.trim()).isEqualTo(out.toString().trim());

    }

    @Test
    void 유저와_컴퓨터_숫자_비교_테스트_3(){
        List<Integer> user = List.of(1,2,3);
        List<Integer> computer = List.of(4,5,1);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(compareUserNumberToComputers(user, computer)).isEqualTo(1);

        String msg = "1볼";
        assertThat(msg.trim()).isEqualTo(out.toString().trim());

    }

    @Test
    void 유저와_컴퓨터_숫자_비교_테스트_4(){
        List<Integer> user = List.of(1,2,3);
        List<Integer> computer = List.of(4,5,6);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(compareUserNumberToComputers(user, computer)).isEqualTo(1);

        String msg = "낫싱";
        assertThat(msg.trim()).isEqualTo(out.toString().trim());

    }

    @Test
    void 게임오버_테스트_1(){
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(isGameOver()).isEqualTo(1);

        String msg = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + System.lineSeparator();
        msg += "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        assertThat(out.toString().trim()).isEqualTo(msg.trim());

    }

    @Test
    void 게임오버_테스트_2(){
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertThat(isGameOver()).isEqualTo(2);

        String msg = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + System.lineSeparator();
        msg += "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        assertThat(out.toString().trim()).isEqualTo(msg.trim());

    }

    @Test
    void 게임오버_테스트_3(){
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Throwable thrown = catchThrowable(() -> isGameOver());
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);

        String msg = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + System.lineSeparator();
        msg += "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        assertThat(out.toString().trim()).isEqualTo(msg.trim());

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
