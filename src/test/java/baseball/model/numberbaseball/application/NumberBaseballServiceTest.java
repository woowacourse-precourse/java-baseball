package baseball.model.numberbaseball.application;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.numberbaseball.NumberBaseball;

class NumberBaseballServiceTest {

	private NumberBaseballService numberBaseballService = new NumberBaseballService();

	@Test
	@DisplayName("세자리 랜덤 숫자는 서로 다른 숫자이어야 한다")
	public void 숫자_중복_테스트() {
		//when
		NumberBaseball numberBaseball = numberBaseballService.createNumberBaseball();

		List<Integer> numbers = numberBaseball.getNumbers();
		long afterDistinct = numbers.stream()
			.distinct()
			.count();

		//then
		Assertions.assertThat(numbers.size()).isEqualTo(afterDistinct);

	}
}