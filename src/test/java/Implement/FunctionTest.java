package Implement;

import baseball.Application;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.assertj.core.api.Assertions.assertThat;


public class FunctionTest{

    @Test
    void 리스트에_3자리_생성() {
        List<Integer> randomNumber = Application.makeRandomNumberList();
        assertThat(randomNumber.size() == 3);
    }

    @Test
    void 서로_다른_수_3자리를_1부터_9까지_랜덤으로_생성() {
        List<Integer> randomNumber = Application.makeRandomNumberList();
        assertNotEquals(randomNumber.get(0), randomNumber.get(1));
        assertNotEquals(randomNumber.get(0), randomNumber.get(2));
        assertNotEquals(randomNumber.get(1), randomNumber.get(2));
    }

    @Test
    void 힌트_출력_여부_낫싱_제외() {
        List<Integer> computer = List.of(1, 2, 3);
        List<String> player = List.of("1", "3", "4");
        String giveHint = Application.checkAnswerAndGiveHint(computer,player);
        assertThat(giveHint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 힌트_출력_여부_낫싱() {
        List<Integer> computer = List.of(1, 2, 3);
        List<String> player = List.of("4", "5", "6");
        String giveHint = Application.checkAnswerAndGiveHint(computer,player);
        assertThat(giveHint).isEqualTo("낫싱");
    }
}
