package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {

	private RandomGenerator randomGenerator;

	@BeforeEach
	void init() {
		randomGenerator = new RandomGenerator();
	}

	@RepeatedTest(value = 10, name = "{currentRepetition}: 1에서 9까지의 난수 생성 검증")
	public void 난수_1_9_생성_검증() {
		//given
		int randomNumber = randomGenerator.generateNumber();
		//when
		boolean validResult = randomNumber >= 1 && randomNumber <= 9;
		//then
		assertThat(validResult).isTrue();
	}

	@RepeatedTest(value = 10, name = "{currentRepetition}: 서로 다른 3개의 난수 생성 검증")
	public void 서로_다른_3개_난수_생성_검증() {
		//given
		List<Integer> randomNumbers = randomGenerator.generateNumbers();
		//when
		int num1 = randomNumbers.get(0);
		int num2 = randomNumbers.get(1);
		int num3 = randomNumbers.get(2);
		boolean actual = num1 != num2 && num1 != num3 && num2 != num3;
		//then
		assertThat(randomNumbers.size()).isEqualTo(3);
		assertThat(actual).isTrue();
	}
}
