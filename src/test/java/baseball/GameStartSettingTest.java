package baseball;

import org.junit.jupiter.api.Test;

public class GameStartSettingTest {
	GameStartSetting gameStartSetting = new GameStartSetting();
	@Test
	void mainTest() {
		System.out.println(gameStartSetting.main());
	}// mainTest
	
	@Test
	void userInputNumberTest() {
		System.out.println(gameStartSetting.userInputNumber());
	}//userInputNumber
}// end class
