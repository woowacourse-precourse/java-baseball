package computer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class JudgmentTest {
    @Test
    void 스트라이크3_판단_테스트(){
        Judgment judgment = new Judgment();
        List<Integer> randomNumber = List.of(1,2,3);
        List<Integer> userNumber = List.of(1,2,3);
        List<Integer> result = judgment.judgeResult(randomNumber,userNumber);
        assertThat(result).isEqualTo(List.of(3,0));
    }

    @Test
    void 스트라이크1_볼2_판단_테스트(){
        Judgment judgment = new Judgment();
        List<Integer> randomNumber = List.of(1,2,3);
        List<Integer> userNumber = List.of(1,3,2);
        List<Integer> result = judgment.judgeResult(randomNumber,userNumber);
        assertThat(result).isEqualTo(List.of(1,2));
    }

    @Test
    void 볼3_판단_테스트(){
        Judgment judgment = new Judgment();
        List<Integer> randomNumber = List.of(1,2,3);
        List<Integer> userNumber = List.of(2,3,1);
        List<Integer> result = judgment.judgeResult(randomNumber,userNumber);
        assertThat(result).isEqualTo(List.of(0,3));
    }

    @Test
    void 볼2_판단_테스트(){
        Judgment judgment = new Judgment();
        List<Integer> randomNumber = List.of(1,2,3);
        List<Integer> userNumber = List.of(2,3,4);
        List<Integer> result = judgment.judgeResult(randomNumber,userNumber);
        assertThat(result).isEqualTo(List.of(0,2));
    }

    @Test
    void 볼1_판단_테스트(){
        Judgment judgment = new Judgment();
        List<Integer> randomNumber = List.of(1,2,3);
        List<Integer> userNumber = List.of(2,5,4);
        List<Integer> result = judgment.judgeResult(randomNumber,userNumber);
        assertThat(result).isEqualTo(List.of(0,1));
    }

    @Test
    void 낫싱_판단_테스트(){
        Judgment judgment = new Judgment();
        List<Integer> randomNumber = List.of(1,2,3);
        List<Integer> userNumber = List.of(7,5,4);
        List<Integer> result = judgment.judgeResult(randomNumber,userNumber);
        assertThat(result).isEqualTo(List.of(0,0));
    }
}
