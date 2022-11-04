package baseball.platerComputer;

import baseball.playerComputer.PlayerComputer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerComputerTest {
	// 0. getRandomDigitTest
	//	@Test void getRandomDigitTest() {
	//		PlayerComputer tester = new PlayerComputer();
	//		int input = tester.getRandomdigit();
	//		assertThat(input).isGreaterThan(0).isLessThan(10);
	//	}

	// 중복된 수가 아닌 세자리 수가 나오는지 확인합니다.
	@Test void getRandomInputNumberTest() {
		PlayerComputer tester = new PlayerComputer();
		int input = tester.getRandomInputNumber();

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			list.add(input % 10);
			input /= 10;
		}

		assertThat(list.get(0)).isNotSameAs(list.get(1));
		assertThat(list.get(0)).isNotSameAs(list.get(2));
		assertThat(list.get(1)).isNotSameAs(list.get(2));
	}

}
