package baseball.model.data;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class UserNumbersTest {

	@DisplayName("유저 입력에 대한 자료형 전처리 수행을 테스트한다")
	@Test
	void testUserInputIsProcessed() {
		LinkedHashMap<Integer, Integer> desirableMap = new LinkedHashMap<>() {
			{
				put(5, 0);
				put(9, 1);
				put(1, 2);
			}
		};
		Assertions.assertThat(UserNumbers.storeNumbers("591")).isEqualTo(desirableMap);
	}
}
