package baseball.controller.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

	@DisplayName("최종 생성된 컴퓨터 난수의 자리수를 확인한다")
	@RepeatedTest(30)
	void testComputerNumberSize() {
		assertThat(Computer.getNumbers().size()).isEqualTo(3);
	}

	@DisplayName("최종 생성된 컴퓨터 난수의 중복 여부를 확인한다")
	@RepeatedTest(30)
	void testComputerNumberWithoutDuplication() {
		LinkedHashMap<Integer, Integer> desirableMap = new LinkedHashMap<>() {
			{
				put(5, 0);
				put(5, 1);
				put(5, 2);
			}
		};

		assertThat(Computer.getNumbers()).isNotSameAs(desirableMap);
	}
}
