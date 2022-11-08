package baseball.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void 숫자_입력_테스트() {
		Player player = new Player();
		player.insertNumber("3");
		assertEquals("3",player.getNumber());

	}
}