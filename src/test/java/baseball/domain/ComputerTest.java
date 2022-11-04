package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;

class ComputerTest extends NsTest {

	@Test
	@DisplayName("3자리 랜덤 숫자 생성 테스트")
	void case1() {
		Computer computer = new Computer();
		List<Integer> test = computer.getNumbers();
		assertThat(3).isEqualTo(test.size());
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}

}