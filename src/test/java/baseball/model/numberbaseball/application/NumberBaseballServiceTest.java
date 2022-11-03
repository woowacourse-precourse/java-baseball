package baseball.model.numberbaseball.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.gameresult.GameResult;
import baseball.model.gameresult.ResultType;
import baseball.model.numberbaseball.NumberBaseball;

class NumberBaseballServiceTest {

	private NumberBaseballService numberBaseballService = new NumberBaseballService();

	@DisplayName("세자리 랜덤 숫자는 서로 다른 숫자이어야 한다")
	@Test
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

	@Test
	public void 게임_결과_테스트_1() {
	    //given
		List<Integer> numbersA = Arrays.asList(1, 2, 3);
		List<Integer> numbersB = Arrays.asList(3, 1, 2);

		NumberBaseball numberBaseballA = new NumberBaseball(numbersA);
		NumberBaseball numberBaseballB = new NumberBaseball(numbersB);

		//when
		GameResult gameResult = numberBaseballService.compareNumberBaseBall(numberBaseballA, numberBaseballB);

		//then
		Map<ResultType, Integer> gameResultMap = gameResult.getGameResult();
		Assertions.assertThat(gameResultMap.get(ResultType.BALL)).isEqualTo(3);
	}

	@Test
	public void 게임_결과_테스트_2() {
		//given
		List<Integer> numbersA = Arrays.asList(1, 2, 3);
		List<Integer> numbersB = Arrays.asList(1, 3, 2);

		NumberBaseball numberBaseballA = new NumberBaseball(numbersA);
		NumberBaseball numberBaseballB = new NumberBaseball(numbersB);

		//when
		GameResult gameResult = numberBaseballService.compareNumberBaseBall(numberBaseballA, numberBaseballB);

		//then
		Map<ResultType, Integer> gameResultMap = gameResult.getGameResult();
		Assertions.assertThat(gameResultMap.get(ResultType.STRIKE)).isEqualTo(1);
		Assertions.assertThat(gameResultMap.get(ResultType.BALL)).isEqualTo(2);
	}

	@Test
	public void 게임_결과_테스트_3() {
		//given
		List<Integer> numbersA = Arrays.asList(7, 1, 3);
		List<Integer> numbersB = Arrays.asList(4, 5, 6);

		NumberBaseball numberBaseballA = new NumberBaseball(numbersA);
		NumberBaseball numberBaseballB = new NumberBaseball(numbersB);

		//when
		GameResult gameResult = numberBaseballService.compareNumberBaseBall(numberBaseballA, numberBaseballB);

		//then
		Map<ResultType, Integer> gameResultMap = gameResult.getGameResult();
		Assertions.assertThat(gameResultMap.get(ResultType.NOTHING)).isEqualTo(3);
		Assertions.assertThat(gameResultMap.get(ResultType.STRIKE)).isNull();
		Assertions.assertThat(gameResultMap.get(ResultType.BALL)).isNull();
	}

	@Test
	public void 게임_결과_테스트_4() {
		//given
		List<Integer> numbersA = Arrays.asList(4, 5, 6);
		List<Integer> numbersB = Arrays.asList(4, 5, 6);

		NumberBaseball numberBaseballA = new NumberBaseball(numbersA);
		NumberBaseball numberBaseballB = new NumberBaseball(numbersB);

		//when
		GameResult gameResult = numberBaseballService.compareNumberBaseBall(numberBaseballA, numberBaseballB);

		//then
		Map<ResultType, Integer> gameResultMap = gameResult.getGameResult();
		Assertions.assertThat(gameResultMap.get(ResultType.STRIKE)).isEqualTo(3);
	}

}