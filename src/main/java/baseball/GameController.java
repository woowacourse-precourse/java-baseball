package baseball;

public class GameController {
	
	void gameStart() {
		GameStartSetting gameStartSetting = new GameStartSetting();
		ResultComparison resultComparison = new ResultComparison();
		String computerValue = gameStartSetting.start();
	
		while(true) {		
			String userValue = gameStartSetting.userNumberPut();
			if(resultComparison.print(computerValue,userValue)) {
				break;
			}//if
		}//while
	}// gameStart
	
	boolean gameExit(String endSignal) {
		boolean exit = false;
		if(endSignal.contains("2")) {
			exit = true;
		}//if
		return exit;
	}// gameExit
}//GameController
