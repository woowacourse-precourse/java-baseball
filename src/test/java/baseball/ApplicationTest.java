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

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
