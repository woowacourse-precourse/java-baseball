package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {
	@Test						/* 컴퓨터 숫자 생성 테스트 */
	void randomGeneratingTest() {
		List<Integer> generatedNumbers = Application.setComputersNumbers();

		assertThat(generatedNumbers.size() == 3);
		for(int number : generatedNumbers) {
			assertThat(number > 0 && number < 10);
		}
	}
}
