package baseball.controller.computer;

import baseball.controller.error.ComputerError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerErrorTest {
	@DisplayName("난수 생성 후 저장시 중복을 확인한다")
	@Test
	void canVerifyDuplication() {
		List<Integer> list1 = List.of(3, 3);
		List<Integer> list2 = List.of(1, 7);
		List<Integer> list3 = List.of(2, 5);

		assertThat(ComputerError.hasDuplication(list1, 3)).isTrue();
		assertThat(ComputerError.hasDuplication(list2, 7)).isTrue();
		assertThat(ComputerError.hasDuplication(list3, 6)).isFalse();
	}

	@DisplayName("난수 생성 후 중복 룰을 따르는지 확인한다")
	@Test
	void canVerifyDuplicationRule() {
		List<Integer> list1 = List.of(3, 3);
		List<Integer> list2 = List.of(1, 7);
		assertThat(ComputerError.followDuplicationRule(list1, 3)).isFalse();
		assertThat(ComputerError.followDuplicationRule(list2, 5)).isTrue();
	}

}
