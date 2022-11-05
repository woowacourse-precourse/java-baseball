import static org.assertj.core.api.Assertions.assertThat;

import baseball.Computer;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CustumTest {
    @Test
    void 랜덤으로_값_가져오기() {
        Computer computer = new Computer();

        List<Integer> computerRandomNumber = computer.getRandomNumber();

        assertThat(computerRandomNumber.size()).isEqualTo(3);

        assertThat(computerRandomNumber).containsOnlyOnce(computerRandomNumber.get(0));
        assertThat(computerRandomNumber).containsOnlyOnce(computerRandomNumber.get(1));
        assertThat(computerRandomNumber).containsOnlyOnce(computerRandomNumber.get(2));
    }

    @Test
    void 힌트_계산하기() {
        Computer computer = new Computer();

        assertThat(computer.calcHint("129", "123")).isEqualTo(Arrays.asList(0, 2));
        assertThat(computer.calcHint("329", "123")).isEqualTo(Arrays.asList(1, 1));
        assertThat(computer.calcHint("319", "123")).isEqualTo(Arrays.asList(2, 0));
        assertThat(computer.calcHint("123", "123")).isEqualTo(Arrays.asList(0, 3));
    }

    @Test
    void 힌트_계산_출력하기() {
        Computer computer = new Computer();

        assertThat(computer.printHint(Arrays.asList(0, 0))).isEqualTo("낫싱");
        assertThat(computer.printHint(Arrays.asList(0, 3))).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        assertThat(computer.printHint(Arrays.asList(1, 2))).isEqualTo("1볼 2스트라이크");
        assertThat(computer.printHint(Arrays.asList(3, 0))).isEqualTo("3볼");
        assertThat(computer.printHint(Arrays.asList(2, 1))).isEqualTo("2볼 1스트라이크");
    }
}
