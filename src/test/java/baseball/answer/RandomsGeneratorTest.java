package baseball.answer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomsGeneratorTest {
    private AnswerGenerator generator;

    @BeforeEach
    void init(){
        generator = new RandomsGenerator();
    }

    @Test
    void 세자리_정답_생성() {
        List<Integer> result = generator.generate();
        System.out.println("result = " + result);

        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void 중복_숫자_없는_정답() {
        List<Integer> answer = generator.generate();

        Set<Integer> result = new HashSet<>(answer);
        System.out.println("result set = " + result);

        assertThat(result.size()).isEqualTo(3);
    }

}