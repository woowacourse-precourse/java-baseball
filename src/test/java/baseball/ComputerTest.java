package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.domain.Computer;

public class ComputerTest {
	Computer computer;
	List<Integer> randomNumberList;

	@BeforeEach
	void setUp() {
		computer = new Computer();
		computer.makeRandomNumber();

		randomNumberList = computer.getRandomNumber();
	}

	@Test
	void selectNumber_메서드로_랜덤_숫자_선택() {
		컴퓨터_숫자_범위_테스트();
		컴퓨터_숫자_개수_테스트();
		컴퓨터_숫자_중복_테스트();
	}

	void 컴퓨터_숫자_범위_테스트() {
		assertThat(randomNumberList.stream().allMatch(n -> n >= 1 && n <= 9)).isTrue();
	}

	void 컴퓨터_숫자_개수_테스트() {
		assertThat(randomNumberList.size()).isEqualTo(3);
	}


	void 컴퓨터_숫자_중복_테스트() {
		boolean isSameNumberExist = randomNumberList.stream()
			.distinct()
			.count() != randomNumberList.size();

		assertThat(isSameNumberExist).isFalse();
	}
}
