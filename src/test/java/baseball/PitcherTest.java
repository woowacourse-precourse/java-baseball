package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PitcherTest {
	@Test
	void 컴퓨터가_생성한_수_검증() {
		Pitcher pitcher = new Pitcher();
		List<Integer> number = pitcher.getNumber();

		//숫자 0을 가지고 있진 않은가?
		assertThat(number).doesNotContain(0);

		//랜덤으로 추출한 숫자 3개가 서로 다른 수인가?
		assertThat(number)
				.containsOnlyOnce(number.get(0))
				.containsOnlyOnce(number.get(1))
				.containsOnlyOnce(number.get(2));
		
		//랜덤으로 추출한 숫자 3개가 1 이상 9 이하의 정수인가?
		assertThat(number.get(0)).isIn(1, 2, 3, 4, 5, 6, 7, 8, 9);
		assertThat(number.get(1)).isIn(1, 2, 3, 4, 5, 6, 7, 8, 9);
		assertThat(number.get(2)).isIn(1, 2, 3, 4, 5, 6, 7, 8, 9);
	}
}
