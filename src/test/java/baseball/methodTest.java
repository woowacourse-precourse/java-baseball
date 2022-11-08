package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

public class methodTest {
	@Test
	void testReadLine() {
		System.out.println("methodTest.testReadLine");
		String str = Console.readLine();
		assertThat(str).isEqualTo("abcd");
	}

	@Test
	void testMakeNumber() {
		System.out.println("methodTest.testMakeNumber");
		int num = Randoms.pickNumberInRange(1, 9);
		for (int i = 0; i < 100; i++) {
			assertThat(num).isBetween(1, 9);
		}
	}
}
