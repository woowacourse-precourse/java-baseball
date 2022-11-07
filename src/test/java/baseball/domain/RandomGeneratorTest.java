package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {

	private RandomGenerator randomGenerator;

	@BeforeEach
	void init() {
		randomGenerator = new RandomGenerator();
	}

	@RepeatedTest(10)
	public void 난수_1_9_생성_테스트() {
		//given
		int randomNumber = randomGenerator.generateNumber();
		System.out.println(randomNumber);
		//when
		boolean validResult = randomNumber >= 1 && randomNumber <= 9;
		//then
		assertThat(validResult).isTrue();
	}
}
