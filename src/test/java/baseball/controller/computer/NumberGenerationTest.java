package baseball.controller.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumberGenerationTest {

	@DisplayName("숫자 생성의 범위를 확인한다")
	@Test
	void testNumberCreationRange() {
		int randomNumber = NumberGeneration.generateOneRandomNumber();

		assertThat(randomNumber).isBetween(1, 9);
	}

	@DisplayName("난수 생성을 확인한다")
	@RepeatedTest(50)
	void testRandomNumberGeneration() {

        /*
          랜덤으로 숫자가 만들어지는 것을 확인하기 위해서
          일정 수준을 여러번 생성하는 시나리오를 가정한다.
          즉,
          9의 크기를 가진 배열에 모든 숫자를 계속 해서 채워 넣는다면
          특정 반복 횟수를 지나
          모든 공간이 채워진다면
          랜덤 숫자가 만들어지는 것이라고 가정하고
          이를 검증한다.
          배열의 공간        0 1 2 3 4 5 6 7 8
          랜덤 숫자          1 2 3 4 5 6 7 8 9
          호출시 1로 초기화   1 1 1 1 1 1 1 1 1 => 합계 9
         */

		int[] counts = new int[10];

		for (int counter = 0; counter < 100; counter++) {
			int randomNumber = NumberGeneration.generateOneRandomNumber();
			counts[randomNumber] = 1;
		}

		int sum = 0;

		for (int counter = 0; counter < 10; counter++) {
			sum += counts[counter];
		}

		assertEquals(9, sum);
	}
}
