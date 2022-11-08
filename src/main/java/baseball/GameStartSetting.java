package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameStartSetting {
	public String start() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		
		return computerNumberPut();
	}//start
	
	private String computerNumberPut() {
		String cumputerNumber = "";
		for(;cumputerNumber.length()<3;) {
		int randomNum = Randoms.pickNumberInRange(1, 9);
		if(cumputerNumber.contains(randomNum+"")) {
			continue;
		}//if
		cumputerNumber +=randomNum;
		}//for
		return cumputerNumber;
	}//computerNumberPut
	
	public String userNumberPut() {
		System.out.print("숫자를 입력해주세요 : ");
		String userInputNumber = Console.readLine();
		if(userInputNumber.length()!=3 || !(userInputNumber.matches("[+-]?\\d*(\\.\\d+)?"))
			|| userInputNumber.charAt(0) == userInputNumber.charAt(1)
			|| userInputNumber.charAt(1) == userInputNumber.charAt(2)
			|| userInputNumber.charAt(2) == userInputNumber.charAt(0)
				) {
			throw new IllegalArgumentException();
		}//if
		return userInputNumber;
	}// userNumberPut
}// end class
