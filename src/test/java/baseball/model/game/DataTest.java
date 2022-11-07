package baseball.model.game;

import baseball.model.data.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.*;

public class DataTest {
	Data data = new Data();

	@DisplayName("LinkedHashMap에서 key 값을 꺼내는 기능을 확인한다")
	@Test
	void canExtractKey() {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>() {
			{
				put(1, 0);
				put(2, 1);
				put(3, 2);
			}
		};
		assertThat(data.extractNumber(map, 0)).isEqualTo(1);
	}

	@DisplayName("LinkedHashMap에서 value 값을 꺼내는 기능을 확인한다")
	@Test
	void canExtractValue() {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>() {
			{
				put(1, 0);
				put(2, 1);
				put(3, 2);
			}
		};
		assertThat(data.extractIndex(map, 0)).isEqualTo(0);
	}
}
