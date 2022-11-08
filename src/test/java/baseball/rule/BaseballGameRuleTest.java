package baseball.rule;

import static org.junit.jupiter.api.Assertions.*;

import baseball.player.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

class BaseballGameRuleTest {

	@Test
	void 플레이어_숫자_유효성_길이_Exception() {
		Player player = new Player();
		player.insertNumber("1");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player,computer);
		assertThrows(
				IllegalArgumentException.class, baseballGameRule::isPlayerNumberValidate);
	}
	@Test
	void 플레이어_숫자_유효성_1부터_9까지_Exception() {
		Player player = new Player();
		player.insertNumber("0");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player,computer);
		assertThrows(
				IllegalArgumentException.class, baseballGameRule::isPlayerNumberValidate);
	}
	@Test
	void 플레이어_숫자_유효성_서도다른숫자_Exception() {
		Player player = new Player();
		player.insertNumber("112");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player,computer);
		assertThrows(
				IllegalArgumentException.class, baseballGameRule::isPlayerNumberValidate);
	}
	@Test
	void 플레이어_숫자_유효성_체크_통과() {
		Player player = new Player();
		player.insertNumber("123");
		Computer computer = Computer.createComputerForTest("123");
		BaseballGameRule baseballGameRule = new BaseballGameRule(player,computer);
		baseballGameRule.isPlayerNumberValidate();
	}



}