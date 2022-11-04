package baseball.playerUser;

import baseball.playerComputer.PlayerComputer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerUserTest {
	// 수가 4개이상 입력된 경우
	@Test void userInputTest1() {
		PlayerUser testUser = PlayerUser.getInstance();
		String number = testUser.getInputNumber();

		System.out.println("user input number : " + number);
		assertThat(number.length()).isGreaterThan(3);
	}

	// 특수문자가 입력된 경우
	@Test void userInputTest2() {
		PlayerUser testUser = PlayerUser.getInstance();
		String number = testUser.getInputNumber();

		System.out.println("user input number : " + number);
		for (char elem : number.toCharArray()) {
			if (elem < '1' && elem > '9') {
				assertThat(number).withFailMessage("잘못된 수를 포함하고 있습니다.");
			}
		}
	}

	// 입력에 공백이 있는 경우
	@Test void userInputTest3() {
		PlayerUser testUser = PlayerUser.getInstance();
		String number = testUser.getInputNumber();

		System.out.println("user input number : " + number);
		assertThat(number).doesNotContain(" ");
	}

	// 수가 음수일 경우
	@Test void userInputTest4() {
		PlayerUser testUser = PlayerUser.getInstance();
		String number = testUser.getInputNumber();

		System.out.println("user input number : " + number);
		int convertedNumber = Integer.parseInt(number);
		assertThat(convertedNumber).isNegative();
	}
}
