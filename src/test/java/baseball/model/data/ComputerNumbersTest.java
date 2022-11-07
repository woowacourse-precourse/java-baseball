package baseball.model.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerNumbersTest {

	@DisplayName("컴퓨터 생성 난수의 자료형 전처리 수행을 테스트한다")
	@Test
	void testComputerNumberIsProcessed() {
		List<Integer> createdList = List.of(5, 9, 1);
		LinkedHashMap<Integer, Integer> desirableMap = new LinkedHashMap<>() {
			{
				put(5, 0);
				put(9, 1);
				put(1, 2);
			}
		};
		assertThat(ComputerNumbers.storeNumbers(createdList)).isEqualTo(desirableMap);
	}
}
