package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class ProblemSolverTest {


    @Test
    void solveProblem_3자리수아닐때() {
        InputStream in = new ByteArrayInputStream("1234".getBytes());
        System.setIn(in);
        ProblemSolver problemSolver = new ProblemSolver();
        assertThatThrownBy(()->problemSolver.solveProblem(Settings.SIZE_OF_NUMBERS)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solveProblem_숫자아닐때() {
        InputStream in = new ByteArrayInputStream("abc".getBytes());
        System.setIn(in);
        ProblemSolver problemSolver = new ProblemSolver();
        assertThatThrownBy(()->problemSolver.solveProblem(Settings.SIZE_OF_NUMBERS)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solveProblem_서로다른수아닐때() {
        InputStream in = new ByteArrayInputStream("333".getBytes());
        System.setIn(in);
        ProblemSolver problemSolver = new ProblemSolver();
        assertThatThrownBy(()->problemSolver.solveProblem(Settings.SIZE_OF_NUMBERS)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void solveProblem_정상() {
        InputStream in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        ProblemSolver problemSolver = new ProblemSolver();
        problemSolver.solveProblem(Settings.SIZE_OF_NUMBERS);
        assertThat(problemSolver.getNumbers()).containsExactly(1,2,3);
    }

    @Test
    void chooseToRestart() {
    }
}