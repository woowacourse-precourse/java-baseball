package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.util.Converter;

class NumberComparatorTest {
	private NumberComparator numberComparator;
	@BeforeEach
	void init() {
		List<Integer> answer = List.of(4, 9, 2);
		numberComparator = new NumberComparator(answer);
	}

	@Test
	void compare_메소드로_오답_검증() {
		//given
		String wrongInput = "283";
		System.setIn(new ByteArrayInputStream(wrongInput.getBytes()));
		List<Integer> digits = Converter.convertStringToIntegerList(wrongInput);

		//when
		numberComparator.compare(digits);

		//then
		assertThat(numberComparator.hasCorrectNumber()).isFalse();
	}

	@Test
	void compare_메소드로_정답_검증() {
		//given
		String rightInput = "492";
		System.setIn(new ByteArrayInputStream(rightInput.getBytes()));
		List<Integer> digits = Converter.convertStringToIntegerList(rightInput);

		//when
		numberComparator.compare(digits);

		//then
		assertThat(numberComparator.hasCorrectNumber()).isTrue();
	}

	@Test
	void getBallsCount_메소드로_볼_개수_세기() {
		//given
		String input = "283";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		List<Integer> digits = Converter.convertStringToIntegerList(input);
		numberComparator.compare(digits);

		//when, then
		assertThat(numberComparator.getBallsCount()).isEqualTo(1);
	}

	@Test
	void getStrikesCount_메소드로_스트라이크_개수_세기() {
		//given
		String input = "429";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		List<Integer> digits = Converter.convertStringToIntegerList(input);
		numberComparator.compare(digits);

		//when, then
		assertThat(numberComparator.getStrikesCount()).isEqualTo(1);
	}

	@Test
	void hasCorrectNumber_메소드로_오답_확인하기() {
		//given
		String input = "429";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		List<Integer> digits = Converter.convertStringToIntegerList(input);
		numberComparator.compare(digits);

		//when, then
		assertThat(numberComparator.hasCorrectNumber()).isEqualTo(false);
	}

	@Test
	void hasCorrectNumber_메소드로_정답_확인하기() {
		//given
		String input = "492";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		List<Integer> digits = Converter.convertStringToIntegerList(input);
		numberComparator.compare(digits);

		//when, then
		assertThat(numberComparator.hasCorrectNumber()).isEqualTo(true);
	}
}