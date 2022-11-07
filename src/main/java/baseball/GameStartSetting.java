package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameStartSetting {
	public String start() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		
		return computerNumberPut();
	}//main
	
	private String computerNumberPut() {
		String cumputerNumber = "";
		for(;cumputerNumber.length()<3;) {
		cumputerNumber = cumputerNumber+Randoms.pickNumberInRange(0, 9);
		}//for
		return cumputerNumber;
	}//computerNumber
	
	public String userNumberPut() {
		String userInputNumber = "";
		System.out.print("숫자를 입력해주세요 :");
		userInputNumber = Console.readLine();
		if(userInputNumber.length()!=3 || !(userInputNumber.matches("[+-]?\\d*(\\.\\d+)?")) ) {
			throw new IllegalArgumentException();
		}//if
		return userInputNumber;
	}// userInput
}// end class
