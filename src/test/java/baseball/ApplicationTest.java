package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	Compare compare = new Compare();
	ComputerNum computerNum = new ComputerNum();
	Input input = new Input();
	Judge judge = new Judge();

	@Test
	void 랜덤_숫자_생성_테스트() {
		List<Integer> test = computerNum.create();
		assertThat(3).isEqualTo(test.size());
	}

	@Test
	void 몇개의_숫자가_같은지_확인() {
		assertThat(3).isEqualTo(compare.howMany(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2)));
	}

	@Test
	void 스트라이크_개수_확인() {
		assertThat(1).isEqualTo(compare.countStrike(Arrays.asList(3, 2, 4), Arrays.asList(3, 1, 2)));
	}

	@Test
	void 볼_개수_확인() {
		assertThat(3).isEqualTo(compare.countBall(Arrays.asList(3, 1, 2), Arrays.asList(1, 2, 3)));
	}

	@Test
	void 세개의_스트라이크_확인() {
		assertThat("3스트라이크").isEqualTo(judge.judgement(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
	}

	@Test
	void 볼과_스트라이크_개수_확인() {
		assertThat("1볼 1스트라이크").isEqualTo(judge.judgement(Arrays.asList(1, 3, 4), Arrays.asList(1, 2, 3)));
	}

	@Test
	void 낫싱확인() {
		assertThat("낫싱").isEqualTo(judge.judgement(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));
	}

	@Test
	void 입력_자릿수가_세자리가_아닐때() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1234"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 범위_내_숫자가_아닐때() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("034"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 입력_값이_중복될_때() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("133"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void 문자열_정수형으로_변환() {
		int i = 0;
		String string = "123";
		int test = input.conversion(string,i);
		assertThat(1).isEqualTo(test);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
