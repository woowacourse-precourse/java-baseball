package baseball.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.player.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

class BaseballGameRuleTest {

	@Test
	void 플레이어_숫자_유효성_길이_Exception() {
		Player player = new Player();
		player.insertNumber("1");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player, computer);
		assertThrows(
				IllegalArgumentException.class, baseballGameRule::isPlayerNumberValidate);
	}

	@Test
	void 플레이어_숫자_유효성_1부터_9까지_Exception() {
		Player player = new Player();
		player.insertNumber("0");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player, computer);
		assertThrows(
				IllegalArgumentException.class, baseballGameRule::isPlayerNumberValidate);
	}

	@Test
	void 플레이어_숫자_유효성_서도다른숫자_Exception() {
		Player player = new Player();
		player.insertNumber("112");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player, computer);
		assertThrows(
				IllegalArgumentException.class, baseballGameRule::isPlayerNumberValidate);
	}

	@Test
	void 플레이어_숫자_유효성_체크_통과() {
		Player player = new Player();
		player.insertNumber("123");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player, computer);
		baseballGameRule.isPlayerNumberValidate();
	}
	@Test
	void 야구게임점수_테스트_3스트라이크(){
		Player player = new Player();
		player.insertNumber("123");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player,computer);
		String score = baseballGameRule.getScore();
		assertEquals("30",score);

	}
	@Test
	void 야구게임점수_테스트_낫띵(){
		Player player = new Player();
		player.insertNumber("123");
		Computer computer = Computer.createComputerForTest("456");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player,computer);
		String score = baseballGameRule.getScore();
		assertEquals("00",score);
	}
	@Test
	void 야구게임점수_테스트_1스트라이크_2볼(){
		Player player = new Player();
		player.insertNumber("123");
		Computer computer = Computer.createComputerForTest("132");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player,computer);
		String score = baseballGameRule.getScore();
		assertEquals("12",score);
	}


}