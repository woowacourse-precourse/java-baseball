package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GraderTest {

	@Test
	void GraderTest1() {
		List<Integer> answer = List.of(1, 2, 3);
		List<Integer> input = List.of(2, 3, 4);
		Grader grader = new Grader(answer);
		Score score = grader.getScore(input);
		assertThat(score.getBall()).isEqualTo(2);
		assertThat(score.getStrike()).isEqualTo(0);
	}

	@Test
	void GraderTest2() {
		List<Integer> answer = List.of(7, 8, 9);
		List<Integer> input = List.of(7, 8, 9);
		Grader grader = new Grader(answer);
		Score score = grader.getScore(input);
		assertThat(score.getBall()).isEqualTo(0);
		assertThat(score.getStrike()).isEqualTo(3);
	}

	@Test
	void GraderTest3() {
		List<Integer> answer = List.of(6, 5, 4);
		List<Integer> input = List.of(6, 4, 5);
		Grader grader = new Grader(answer);
		Score score = grader.getScore(input);
		assertThat(score.getBall()).isEqualTo(2);
		assertThat(score.getStrike()).isEqualTo(1);
	}
}
