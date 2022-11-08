package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;

import baseball.domain.Balls;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class NumberGeneratorTest {

	@DisplayName("중복되지 않은 3자리 숫자 생성 테스트")
	@RepeatedTest(50)
	void createNonDuplicateNumbers_중복되지_않은_3자리_숫자_생성() {
		List<Integer> numbers
			= NumberGenerator.createNonDuplicateNumbers();
		assertDoesNotThrow(() -> new Balls(numbers));
	}
}
