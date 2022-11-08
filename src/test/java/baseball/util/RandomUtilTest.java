package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilTest {

	@Test
	@DisplayName("3자리의 숫자가 유니크하게 나오는지 확인")
	void 숫자_3개가_유니크하게_나오는지_확인() {
		for (int i = 0; i < (int) Math.pow(3, 9); i++){
			assertThat(RandomUtil.getRandomUniqueNumbers(1, 9, 3).size()).isEqualTo(3);
		}

	}

	@Test
	@DisplayName("숫자의 범위가 1~9 사이인지에 대한 여부")
	void 숫자_범위_확인() {
		assertThat(RandomUtil.getNumber(1, 9)).isBetween(1, 9);
	}
}
