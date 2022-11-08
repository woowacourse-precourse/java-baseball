package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerPlayerTest {

	@DisplayName("상대플레이어의 숫자갯수 테스트")
	@Test
	void isRightDigitNumber() {
		// given
		ComputerPlayer computerPlayer = new ComputerPlayer();

		// when
		List<Integer> computerNumbers = computerPlayer.getNumberList();

		// then
		assertThat(computerNumbers.size()).isEqualTo(GameRules.DIGIT_NUMBER.getCode());
	}

	@DisplayName("상대플레이어의 숫자랜덤생성여부 테스트")
	@Test
	void isRandomNumber() {
		// given
		ComputerPlayer computerPlayer = new ComputerPlayer();
		ComputerPlayer otherPlayer = new ComputerPlayer();

		// when
		List<Integer> computerNumbers = computerPlayer.getNumberList();
		List<Integer> otherNumbers = otherPlayer.getNumberList();

		// then
		assertThat(computerNumbers).isNotEqualTo(otherNumbers);
	}

}
