package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class FunctionTest extends NsTest {

	@Test
	void TestSetComputersList() {
		Computer computer = new Computer();
		computer.setComputersList();

		for(int i = 0; i < 3; i++) {
			assertThat(computer.computersList.get(i)).isBetween(1, 9);
		}

		assertThat(computer.computersList.size()).isEqualTo(3);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}
}
