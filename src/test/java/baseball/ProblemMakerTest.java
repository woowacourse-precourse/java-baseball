package baseball;

import camp.nextstep.edu.missionutils.Randoms;
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
    void hasNumber_없는숫자일경우() {
        ProblemMaker problemMaker = new ProblemMaker();
        problemMaker.makeProblem(Settings.SIZE_OF_NUMBERS);
        List<Integer> numbers = problemMaker.getNumbers();
        int num = Randoms.pickNumberInRange(1,9);
        while(numbers.contains(num)){
            num = Randoms.pickNumberInRange(1,9);
        }
        boolean result = false;
        assertThat(result).isEqualTo(problemMaker.hasNumber(num));
    }

    @Test
    void hasNumber_있는숫자일경우() {
        ProblemMaker problemMaker = new ProblemMaker();
        problemMaker.makeProblem(Settings.SIZE_OF_NUMBERS);
        List<Integer> numbers = problemMaker.getNumbers();
        int num = numbers.get(0);
        boolean result = true;
        assertThat(result).isEqualTo(problemMaker.hasNumber(num));
    }

    @Test
    void isSameAtGivenLocation() {
    }
}