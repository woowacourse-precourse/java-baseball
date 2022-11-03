package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class GameResultTest {
	@Test
	void 결과값이_스트라이크_셋_볼_없음() {
		List<Integer> comNums = List.of(1, 2, 3);
		List<Integer> userNums = List.of(1, 2, 3);
		GameResult result = new GameResult(comNums, userNums);
		assertEquals(result.strikeCount, 3);
		assertEquals(result.ballCount, 0);
	}

	@Test
	void 결과값이_스트라이크_없음_볼_셋() {
		List<Integer> comNums = List.of(3, 1, 2);
		List<Integer> userNums = List.of(1, 2, 3);
		GameResult result = new GameResult(comNums, userNums);
		assertEquals(result.strikeCount, 0);
		assertEquals(result.ballCount, 3);
	}

	@Test
	void 결과값이_스트라이크_하나_볼_둘() {
		List<Integer> comNums = List.of(2, 4, 3);
		List<Integer> userNums = List.of(2, 3, 4);
		GameResult result = new GameResult(comNums, userNums);
		assertEquals(result.strikeCount, 1);
		assertEquals(result.ballCount, 2);
	}
}
