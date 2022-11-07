package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void addAllUserInputNumberListTest() {
		List<Integer> userInputNumberList;
		List<Integer> tempList = new ArrayList<>();
		User user = new User();

		user.addAllUserInputNumberList(tempList);
		userInputNumberList = user.getUserInputNumberList();
		Assertions.assertThat(userInputNumberList).isEmpty();

		for (int tempIndex = 0; tempIndex < 10; tempIndex++) {
			tempList.add(tempIndex);
		}
		user.addAllUserInputNumberList(tempList);
		userInputNumberList = user.getUserInputNumberList();
		Assertions.assertThat(userInputNumberList).isEqualTo(tempList);
	}

	@Test
	void clearUserInputNumberListTest() {
		List<Integer> userInputNumberList;
		List<Integer> tempList = new ArrayList<>();
		User user = new User();

		for (int tempIndex = 0; tempIndex < 10; tempIndex++) {
			tempList.add(tempIndex);
		}
		user.addAllUserInputNumberList(tempList);
		userInputNumberList = user.getUserInputNumberList();
		Assertions.assertThat(userInputNumberList).isEqualTo(tempList);

		user.clearUserInputNumberList();
		userInputNumberList = user.getUserInputNumberList();
		Assertions.assertThat(userInputNumberList).isEmpty();
	}
}
