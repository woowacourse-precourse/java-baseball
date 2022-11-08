package baseball;

import org.junit.jupiter.api.Test;

public class GameStartSettingTest {
	GameStartSetting gameStartSetting = new GameStartSetting();
	@Test
	void startTest() {
		System.out.println(gameStartSetting.start());
	}// mainTest
	
	@Test
	void userNumberPutTest() {
		System.out.println(gameStartSetting.userNumberPut());
	}//userInputNumber
}// end class
