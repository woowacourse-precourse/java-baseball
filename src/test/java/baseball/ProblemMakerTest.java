package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ProblemMakerTest {

    @Test
    void makeProblem_리스트크기3인지() {
        ProblemMaker problemMaker = new ProblemMaker();
        problemMaker.makeProblem(Settings.SIZE_OF_NUMBERS);
        int result = Settings.SIZE_OF_NUMBERS;
        assertThat(result).isEqualTo(problemMaker.getNumbers().size());
    }

    @Test
    void makeProblem_1에서9사이값인지() {
        ProblemMaker problemMaker = new ProblemMaker();
        problemMaker.makeProblem(Settings.SIZE_OF_NUMBERS);
        assertThat(problemMaker.getNumbers().stream().allMatch(v -> v>=1 && v<=9)).isTrue();
    }

    @Test
    void makeProblem_서로다른값인지() {
        ProblemMaker problemMaker = new ProblemMaker();
        problemMaker.makeProblem(Settings.SIZE_OF_NUMBERS);
        List<Integer> numbers = problemMaker.getNumbers();
        for(int i = 0;i<Settings.SIZE_OF_NUMBERS;i++){
            int number = numbers.get(i);
            assertThat(numbers.stream().filter(v -> v.equals(number)).count()).isEqualTo(1);
        }
    }

    @Test
    void hasNumber() {
    }

    @Test
    void isSameAtGivenLocation() {
    }
}