package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static baseball.Computer.getComputer;
import static baseball.Constant.MAX;
import static baseball.Constant.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    // Computer class 구현을 위한 테스트 코드
    @Test
    public void 임의의_수가_3개인지_테스트() {
        // given, when
        Computer computer = getComputer();
        List<Integer> number = computer.createRandomNumber();
        // then
        assertThat(number.size()).isEqualTo(3);
    }

    @Test
    public void 임의의_수가_서로_다른_숫자인지_테스트() {
        // given, when
        Computer computer = getComputer();
        List<Integer> before_number = computer.createRandomNumber();
        Set<Integer> after_number = new HashSet<>(before_number);
        // then
        assertThat(after_number.size()).isEqualTo(before_number.size());
    }

    @Test
    public void 임의의_3자리_숫자의_범위_테스트() {
        // given, when
        Computer computer = getComputer();
        List<Integer> number = computer.createRandomNumber();
        List<Integer> range = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // then
        for(int numberIndex = 0; numberIndex < MAX; numberIndex++) {
            assertThat(range).contains(number.get(numberIndex));
        }
    }

    @Test
    public void 플레이어가_입력한_숫자_스트라이크_테스트() {
        // given
        Computer computer = getComputer();
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> userInput = Arrays.asList(1,2,3);
        // when
        String result = computer.judgeNumber(answer, userInput);
        // then
        assertThat(result).isEqualTo(STRIKE);
    }

    @Test
    public void 플레이어가_입력한_숫자_n볼_n스트라이크_테스트() {
        // given
        Computer computer = getComputer();
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> userInput = Arrays.asList(2,4,3);
        // when
        String result = computer.judgeNumber(answer, userInput);
        // then
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void 플레이어가_입력한_숫자_n볼_테스트() {
        // given
        Computer computer = getComputer();
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> userInput = Arrays.asList(2,1,4);
        // when
        String result = computer.judgeNumber(answer, userInput);
        // then
        assertThat(result).isEqualTo("2볼");
    }

    @Test
    public void 플레이어가_입력한_숫자_n스트라이크_테스트() {
        // given
        Computer computer = getComputer();
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> userInput = Arrays.asList(1,5,4);
        // when
        String result = computer.judgeNumber(answer, userInput);
        // then
        assertThat(result).isEqualTo("1스트라이크");
    }

    @Test
    public void 플레이어가_입력한_숫자_낫싱_테스트() {
        // given
        Computer computer = getComputer();
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> userInput = Arrays.asList(4,5,6);
        // when
        String result = computer.judgeNumber(answer, userInput);
        // then
        assertThat(result).isEqualTo("낫싱");
    }
}
