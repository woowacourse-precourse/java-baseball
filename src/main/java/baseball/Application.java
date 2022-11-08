package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	public static void main(String[] args){
		GameController gameController = new GameController();
		
		while(true) {
			gameController.gameStart();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String RestartSignal = Console.readLine();
			if(gameController.gameExit(RestartSignal)) {
				break;
			}//if
		}// while
    }// main
}// class
