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
		PlayerComputer tester = PlayerComputer.getInstance();
		String input = tester.getRandomInputNumber();

		System.out.println("generated Random Number : " + input);
		assertThat(input.charAt(0)).isNotSameAs(input.charAt(1));
		assertThat(input.charAt(0)).isNotSameAs(input.charAt(2));
		assertThat(input.charAt(1)).isNotSameAs(input.charAt(2));
	}

}
