package baseball.model;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameCalculatorTest {
	@Test
	void 테스트케이스() {
		//given
		BaseballGameCalculator cal = new BaseballGameCalculator();
		BaseballNumber answer = new UserBaseballNumber("234");
		List<String> testUserInputList = List.of("123", "467", "259", "231", "234");
		List<int[]> expectedResultList = List.of(new int[] {2, 0}, new int[] {1, 0}, new int[] {0, 1}
			, new int[] {0, 2}, new int[] {0, 3});

		//when
		List<int[]> calculateResultList = new ArrayList<>();
		for (String input : testUserInputList) {
			calculateResultList.add(cal.calculateBSO(new UserBaseballNumber(input), answer));
		}

		//then
		for (int i = 0; i < testUserInputList.size(); i++){
			Assertions.assertThat(calculateResultList.get(i)).isEqualTo(expectedResultList.get(i));
		}
	}
}